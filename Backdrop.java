package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.function.BooleanSupplier;
import javax.swing.JPanel;

/** Animated futuristic background: gradient, grid, scanning line and a drifting dot network. */
public class Backdrop extends JPanel {

    // Time between animation frames in milliseconds. Raise to 100 if it feels laggy.
    private static final int FRAME_MS = 50;
    private static final int COUNT = 46;
    private static final double LINK = 170;

    private final double[] x = new double[COUNT];
    private final double[] y = new double[COUNT];
    private final double[] vx = new double[COUNT];
    private final double[] vy = new double[COUNT];
    private final javax.swing.Timer timer;
    private final long t0 = System.currentTimeMillis();
    private long last = t0;
    private BufferedImage cache;
    private BooleanSupplier active = () -> true;

    public Backdrop(LayoutManager layout) {
        super(layout);
        setOpaque(true);
        Random r = new Random(11);
        for (int i = 0; i < COUNT; i++) {
            x[i] = r.nextDouble();
            y[i] = r.nextDouble();
            vx[i] = (r.nextDouble() - 0.5) * 0.03;
            vy[i] = (r.nextDouble() - 0.5) * 0.03;
        }
        timer = new javax.swing.Timer(FRAME_MS, e -> tick());
        timer.start();
    }

    /** The animation only runs while this returns true. */
    public void setActiveWhen(BooleanSupplier supplier) {
        this.active = supplier;
    }

    private void tick() {
        long now = System.currentTimeMillis();
        double dt = Math.min(0.2, (now - last) / 1000.0);
        last = now;
        if (!isShowing() || !active.getAsBoolean()) {
            return;
        }
        for (int i = 0; i < COUNT; i++) {
            x[i] += vx[i] * dt;
            y[i] += vy[i] * dt;
            if (x[i] < 0 || x[i] > 1) {
                vx[i] = -vx[i];
                x[i] = Math.max(0, Math.min(1, x[i]));
            }
            if (y[i] < 0 || y[i] > 1) {
                vy[i] = -vy[i];
                y[i] = Math.max(0, Math.min(1, y[i]));
            }
        }
        repaint();
    }

    @Override
    public void removeNotify() {
        timer.stop();
        super.removeNotify();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        if (cache == null || cache.getWidth() != w || cache.getHeight() != h) {
            cache = buildStatic(w, h);
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.drawImage(cache, 0, 0, null);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double t = (System.currentTimeMillis() - t0) / 1000.0;

        // Scanning light line that moves down the screen
        int scanY = (int) ((t * 70) % (h + 240)) - 120;
        g2.setPaint(new GradientPaint(0, scanY - 70, new Color(56, 189, 248, 0),
                0, scanY, new Color(56, 189, 248, 34)));
        g2.fillRect(0, scanY - 70, w, 70);
        g2.setPaint(new GradientPaint(0, scanY, new Color(56, 189, 248, 34),
                0, scanY + 70, new Color(56, 189, 248, 0)));
        g2.fillRect(0, scanY, w, 70);

        // Network of connected dots
        g2.setStroke(new BasicStroke(1f));
        for (int i = 0; i < COUNT; i++) {
            for (int j = i + 1; j < COUNT; j++) {
                double dx = (x[i] - x[j]) * w;
                double dy = (y[i] - y[j]) * h;
                double d = Math.sqrt(dx * dx + dy * dy);
                if (d < LINK) {
                    int a = (int) (70 * (1 - d / LINK));
                    g2.setColor(new Color(56, 189, 248, a));
                    g2.drawLine((int) (x[i] * w), (int) (y[i] * h),
                            (int) (x[j] * w), (int) (y[j] * h));
                }
            }
        }
        for (int i = 0; i < COUNT; i++) {
            int px = (int) (x[i] * w);
            int py = (int) (y[i] * h);
            Color c = (i % 3 == 0) ? new Color(139, 92, 246) : new Color(56, 189, 248);
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 40));
            g2.fillOval(px - 5, py - 5, 11, 11);
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 170));
            g2.fillOval(px - 2, py - 2, 5, 5);
        }
        g2.dispose();
    }

    // The parts that never move are drawn once and reused, to keep it fast
    private BufferedImage buildStatic(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(new GradientPaint(0, 0, new Color(0x050816), w, h, new Color(0x0e0726)));
        g2.fillRect(0, 0, w, h);

        orb(g2, w * 0.18, h * 0.22, 360f, new Color(0x38bdf8));
        orb(g2, w * 0.82, h * 0.78, 420f, new Color(0x8b5cf6));
        orb(g2, w * 0.60, h * 0.12, 280f, new Color(0x22d3ee));

        g2.setStroke(new BasicStroke(1f));
        g2.setColor(new Color(56, 189, 248, 16));
        for (int gx = 0; gx < w; gx += 52) {
            g2.drawLine(gx, 0, gx, h);
        }
        for (int gy = 0; gy < h; gy += 52) {
            g2.drawLine(0, gy, w, gy);
        }
        g2.dispose();
        return img;
    }

    private static void orb(Graphics2D g2, double cx, double cy, float radius, Color c) {
        Color center = new Color(c.getRed(), c.getGreen(), c.getBlue(), 60);
        Color edge = new Color(c.getRed(), c.getGreen(), c.getBlue(), 0);
        g2.setPaint(new RadialGradientPaint(new Point2D.Double(cx, cy), radius,
                new float[]{0f, 1f}, new Color[]{center, edge}));
        g2.fill(new Ellipse2D.Double(cx - radius, cy - radius, radius * 2, radius * 2));
    }
}