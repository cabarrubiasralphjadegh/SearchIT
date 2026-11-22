package org.example;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.event.HierarchyEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleConsumer;
import javax.swing.JComponent;
import javax.swing.JPanel;

/** Small helpers for fonts and animations. */
public class Fx {

    private static Font headBase;
    private static Font bodyBase;
    private static Font bodyBoldBase;
    private static boolean loaded;

    private static Font load(String fileName) {
        try {
            File f = new File("fonts/" + fileName);
            if (f.exists()) {
                Font font = Font.createFont(Font.TRUETYPE_FONT, f);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
                System.out.println("Font loaded: " + font.getFontName());
                return font;
            }
            System.out.println("Font file not found: " + f.getPath());
        } catch (Exception e) {
            System.out.println("Font failed (" + fileName + "): " + e);
        }
        return null;
    }

    private static void ensureLoaded() {
        if (loaded) {
            return;
        }
        loaded = true;
        headBase = load("Audiowide-Regular.ttf");
        bodyBase = load("Rajdhani-Medium.ttf");
        bodyBoldBase = load("Rajdhani-Bold.ttf");
    }

    /** Sci-fi display font for titles and headings. */
    public static Font heading(int style, float size) {
        ensureLoaded();
        Map<TextAttribute, Object> attrs = new HashMap<>();
        attrs.put(TextAttribute.TRACKING, 0.04);
        if (headBase == null) {
            return new Font(Font.MONOSPACED, style, Math.round(size)).deriveFont(attrs);
        }
        return headBase.deriveFont(Font.PLAIN, size).deriveFont(attrs);
    }

    /** Modern body font (Rajdhani is small, so the size is scaled up a little). */
    public static Font body(int style, float size) {
        ensureLoaded();
        boolean bold = (style & Font.BOLD) != 0;
        Font base = bold ? bodyBoldBase : bodyBase;
        if (base == null) {
            return new Font("SansSerif", style, Math.round(size));
        }
        return base.deriveFont(Font.PLAIN, size * 1.15f);
    }

    /** Runs onFrame about 60 times a second with a value easing from 0 to 1. */
    public static void animate(int durationMs, DoubleConsumer onFrame) {
        long start = System.currentTimeMillis();
        javax.swing.Timer timer = new javax.swing.Timer(16, null);
        timer.addActionListener(e -> {
            double p = Math.min(1.0, (System.currentTimeMillis() - start) / (double) durationMs);
            double eased = 1 - Math.pow(1 - p, 3);
            onFrame.accept(eased);
            if (p >= 1.0) {
                timer.stop();
            }
        });
        timer.start();
    }

    /** Runs an action once after a delay. */
    public static void later(int delayMs, Runnable action) {
        javax.swing.Timer timer = new javax.swing.Timer(delayMs, e -> action.run());
        timer.setRepeats(false);
        timer.start();
    }

    /** Runs an action every time the component becomes visible. */
    public static void onShow(JComponent c, Runnable action) {
        c.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && c.isShowing()) {
                action.run();
            }
        });
    }

    /** A panel that fades in each time it is shown. */
    public static class FadePanel extends JPanel {
        private float alpha = 1f;

        public FadePanel(LayoutManager layout) {
            super(layout);
            onShow(this, () -> {
                setAlpha(0f);
                animate(380, p -> setAlpha((float) p));
            });
        }

        public void setAlpha(float a) {
            alpha = Math.max(0f, Math.min(1f, a));
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
            super.paint(g2);
            g2.dispose();
        }
    }
}