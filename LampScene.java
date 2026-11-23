package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Login background: a dark room with a floor lamp. Clicking the lamp or its
 * pull cord turns the light on or off. Each time it turns on, the light takes
 * the next neon colour. The window listens through setOnToggle / setOnTheme.
 */
public class LampScene extends JPanel {

    private static final Color[] THEMES = {
        new Color(0x38bdf8), new Color(0xa78bfa), new Color(0xf472b6), new Color(0x2dd4bf)
    };
    private static final int FRAME_MS = 60;

    private int themeIndex = -1;
    private Color theme = THEMES[0];
    private boolean lit = false;
    private boolean busy = false;
    private boolean hoverLamp = false;
    private double glow = 0;
    private double pull = 0;
    private double tick = 0;

    // each dot: x, y (0..1), radius, speed, phase, ring (1) or solid (0)
    private final double[][] dots = new double[30][6];
    private Timer timer;
    private Consumer<Boolean> onToggle = b -> { };
    private Consumer<Color> onTheme = c -> { };

    public LampScene(LayoutManager layout) {
        super(layout);
        setOpaque(true);

        Random r = new Random(11);
        for (double[] d : dots) {
            d[0] = r.nextDouble();
            d[1] = r.nextDouble();
            d[2] = 6 + r.nextDouble() * 40;
            d[3] = 0.0004 + r.nextDouble() * 0.0012;
            d[4] = r.nextDouble() * 6.28;
            d[5] = r.nextInt(3) == 0 ? 1 : 0;
        }

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                boolean over = hitLamp(e.getX(), e.getY());
                if (over != hoverLamp) {
                    hoverLamp = over;
                    setCursor(over ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                                   : Cursor.getDefaultCursor());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (hitLamp(e.getX(), e.getY())) {
                    pullCord();
                }
            }
        };
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    // ---------- public API ----------

    public void setOnToggle(Consumer<Boolean> c) {
        onToggle = c;
    }

    public void setOnTheme(Consumer<Color> c) {
        onTheme = c;
    }

    public boolean isLit() {
        return lit;
    }

    public Color getTheme() {
        return theme;
    }

    // ---------- behaviour ----------

    private void pullCord() {
        if (busy) {
            return;
        }
        busy = true;

        Fx.animate(380, t -> {
            pull = Math.sin(Math.PI * t);
            repaint();
        });

        boolean on = !lit;
        lit = on;
        if (on) {
            themeIndex = (themeIndex + 1) % THEMES.length;
            theme = THEMES[themeIndex];
            onTheme.accept(theme);
        }
        onToggle.accept(on);

        double from = glow;
        double to = on ? 1 : 0;
        Fx.animate(on ? 900 : 600, t -> {
            glow = from + (to - from) * t;
            repaint();
        });
        Fx.later(1000, () -> busy = false);
    }

    private void step() {
        if (!isShowing()) {
            return;
        }
        tick += 0.12;
        for (double[] d : dots) {
            d[1] -= d[3];
            if (d[1] < -0.1) {
                d[1] = 1.1;
            }
        }
        repaint();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (timer == null) {
            timer = new Timer(FRAME_MS, e -> step());
            timer.start();
        }
    }

    @Override
    public void removeNotify() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        super.removeNotify();
    }

    // ---------- geometry (all sizes are in "units": height / 900) ----------

    private double u() {
        return getHeight() / 900.0;
    }

    private double cx() {
        return getWidth() * 0.26;
    }

    private double cordLength() {
        return (170 + 45 * pull) * u();
    }

    private boolean hitLamp(int x, int y) {
        double u = u();
        double cx = cx();
        Rectangle2D shade = new Rectangle2D.Double(cx - 115 * u, 140 * u, 230 * u, 200 * u);
        double cordX = cx + 24 * u;
        double bottom = 336 * u + cordLength() + 24 * u;
        Rectangle2D cord = new Rectangle2D.Double(cordX - 18 * u, 330 * u, 36 * u, bottom - 330 * u);
        return shade.contains(x, y) || cord.contains(x, y);
    }

    // ---------- drawing ----------

    private static Color alpha(Color c, int a) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), Math.max(0, Math.min(255, a)));
    }

    private static Color mix(Color a, Color b, double t) {
        t = Math.max(0, Math.min(1, t));
        return new Color(
                (int) (a.getRed() + (b.getRed() - a.getRed()) * t),
                (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t),
                (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        double u = u();
        double cx = cx();
        double shadeTop = 160 * u;
        double shadeBottom = 330 * u;
        double floor = 800 * u;

        // room
        g2.setPaint(new GradientPaint(0, 0, new Color(0x060914), 0, h, new Color(0x0b1020)));
        g2.fillRect(0, 0, w, h);
        if (glow > 0.01) {
            g2.setPaint(new RadialGradientPaint(new Point2D.Double(cx, 300 * u), (float) (720 * u),
                    new float[]{0f, 1f},
                    new Color[]{alpha(theme, (int) (85 * glow)), alpha(theme, 0)}));
            g2.fillRect(0, 0, w, h);
        }

        // floating light circles
        double k = 0.18 + 0.82 * glow;
        for (double[] d : dots) {
            double x = d[0] * w + Math.sin(tick * 0.6 + d[4]) * 14;
            double y = d[1] * h;
            double r = d[2] * u;
            Ellipse2D e = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
            if (d[5] == 1) {
                g2.setColor(alpha(theme, (int) (70 * k)));
                g2.setStroke(new BasicStroke(1.4f));
                g2.draw(e);
            } else {
                g2.setColor(alpha(theme, (int) (34 * k)));
                g2.fill(e);
            }
        }

        // light cone and floor pool
        if (glow > 0.01) {
            Path2D cone = new Path2D.Double();
            cone.moveTo(cx - 105 * u, shadeBottom);
            cone.lineTo(cx + 105 * u, shadeBottom);
            cone.lineTo(cx + 430 * u, floor);
            cone.lineTo(cx - 430 * u, floor);
            cone.closePath();
            g2.setPaint(new GradientPaint(0, (float) shadeBottom, alpha(theme, (int) (105 * glow)),
                    0, (float) floor, alpha(theme, (int) (8 * glow))));
            g2.fill(cone);

            AffineTransform old = g2.getTransform();
            g2.translate(cx, floor);
            g2.scale(1, 0.16);
            g2.setPaint(new RadialGradientPaint(new Point2D.Double(0, 0), (float) (420 * u),
                    new float[]{0f, 1f},
                    new Color[]{alpha(theme, (int) (110 * glow)), alpha(theme, 0)}));
            g2.fill(new Ellipse2D.Double(-420 * u, -420 * u, 840 * u, 840 * u));
            g2.setTransform(old);

            g2.setPaint(new RadialGradientPaint(new Point2D.Double(cx, shadeBottom - 40 * u),
                    (float) (260 * u), new float[]{0f, 1f},
                    new Color[]{alpha(theme, (int) (95 * glow)), alpha(theme, 0)}));
            g2.fill(new Ellipse2D.Double(cx - 260 * u, shadeBottom - 300 * u, 520 * u, 520 * u));
        }

        // legs, pole, hub
        g2.setStroke(new BasicStroke((float) (7 * u), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(new Color(0x2a3552));
        g2.draw(new Line2D.Double(cx, 620 * u, cx - 130 * u, floor));
        g2.draw(new Line2D.Double(cx, 620 * u, cx + 130 * u, floor));
        g2.draw(new Line2D.Double(cx, 620 * u, cx + 28 * u, floor - 30 * u));
        g2.setStroke(new BasicStroke((float) (6 * u), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(new Color(0x8f9db8));
        g2.draw(new Line2D.Double(cx, shadeBottom, cx, 620 * u));
        g2.setColor(new Color(0xaab6cc));
        g2.fill(new Ellipse2D.Double(cx - 9 * u, 606 * u, 18 * u, 28 * u));

        // finial
        g2.setStroke(new BasicStroke((float) (3 * u), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(new Color(0x8f9db8));
        g2.draw(new Line2D.Double(cx, shadeTop, cx, shadeTop - 22 * u));
        g2.fill(new Ellipse2D.Double(cx - 5 * u, shadeTop - 30 * u, 10 * u, 10 * u));

        // shade
        Path2D shade = new Path2D.Double();
        shade.moveTo(cx - 50 * u, shadeTop);
        shade.lineTo(cx + 50 * u, shadeTop);
        shade.lineTo(cx + 115 * u, shadeBottom);
        shade.lineTo(cx - 115 * u, shadeBottom);
        shade.closePath();

        Color dark1 = new Color(0x1b2238);
        Color dark2 = new Color(0x0e1324);
        Color bright = mix(theme, Color.WHITE, 0.35);
        g2.setPaint(new LinearGradientPaint((float) (cx - 115 * u), 0, (float) (cx + 115 * u), 0,
                new float[]{0f, 0.5f, 1f},
                new Color[]{mix(dark2, theme, 0.55 * glow),
                            mix(dark1, bright, 0.85 * glow),
                            mix(dark2, theme, 0.55 * glow)}));
        g2.fill(shade);

        Shape oldClip = g2.getClip();
        g2.clip(shade);
        g2.setStroke(new BasicStroke(1f));
        g2.setColor(new Color(0, 0, 0, (int) (60 - 30 * glow)));
        for (int i = 1; i < 18; i++) {
            double xt = cx - 50 * u + i * (100 * u / 18);
            double xb = cx - 115 * u + i * (230 * u / 18);
            g2.draw(new Line2D.Double(xt, shadeTop, xb, shadeBottom));
        }
        g2.setClip(oldClip);

        Ellipse2D opening = new Ellipse2D.Double(cx - 115 * u, shadeBottom - 14 * u, 230 * u, 28 * u);
        g2.setColor(mix(dark2, bright, 0.95 * glow));
        g2.fill(opening);
        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(mix(new Color(0x2a3552), theme, glow));
        g2.draw(opening);
        g2.setColor(mix(dark1, theme, 0.4 * glow));
        g2.fill(new Ellipse2D.Double(cx - 50 * u, shadeTop - 5 * u, 100 * u, 10 * u));

        // pull cord
        double cordX = cx + 24 * u;
        double y0 = 336 * u;
        double y1 = y0 + cordLength();
        g2.setStroke(new BasicStroke((float) (2.4 * u), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1f, new float[]{(float) (2 * u), (float) (3 * u)}, 0f));
        g2.setColor(mix(new Color(0x8f9db8), theme, 0.5 * glow));
        g2.draw(new Line2D.Double(cordX, y0, cordX, y1));
        g2.setColor(mix(new Color(0xaab6cc), theme, 0.6 * glow));
        g2.fill(new Ellipse2D.Double(cordX - 6 * u, y1 - 2 * u, 12 * u, 16 * u));

        // hint text
        String s = lit ? "PULL AGAIN TO DIM" : "PULL THE CORD TO LIGHT UP";
        g2.setFont(Fx.body(Font.BOLD, 12f).deriveFont(Map.of(TextAttribute.TRACKING, 0.22f)));
        double pulse = lit ? 0.6 : 0.5 + 0.35 * Math.sin(tick * 1.6);
        g2.setColor(new Color(170, 182, 204, (int) (255 * pulse)));
        g2.drawString(s, (float) (cordX + 26 * u), (float) (y1 + 6 * u));

        g2.dispose();
    }
}