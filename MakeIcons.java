package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** Draws the phone app icons (docs/icon-192.png and docs/icon-512.png). */
public class MakeIcons {

    public static void main(String[] args) throws IOException {
        new File("docs").mkdirs();
        draw(192, new File("docs/icon-192.png"));
        draw(512, new File("docs/icon-512.png"));
        System.out.println("Icons written to docs/");
    }

    private static void draw(int size, File out) throws IOException {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        double s = size;

        g.setPaint(new GradientPaint(0, 0, new Color(0x070b1d), (float) s, (float) s, new Color(0x1d1046)));
        g.fillRect(0, 0, size, size);

        Color cyan = new Color(0x38bdf8);
        Color violet = new Color(0x8b5cf6);
        double cx = s * 0.45, cy = s * 0.45, r = s * 0.21;

        // soft glow behind the magnifier
        for (int i = 8; i >= 1; i--) {
            g.setColor(new Color(56, 189, 248, 12));
            g.setStroke(new BasicStroke((float) (s * 0.035 * i), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.draw(new Ellipse2D.Double(cx - r, cy - r, 2 * r, 2 * r));
            g.draw(new Line2D.Double(cx + r * 0.72, cy + r * 0.72, s * 0.72, s * 0.72));
        }

        g.setPaint(new GradientPaint((float) (cx - r), (float) (cy - r), cyan, (float) (cx + r), (float) (cy + r), violet));
        g.setStroke(new BasicStroke((float) (s * 0.065), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(new Ellipse2D.Double(cx - r, cy - r, 2 * r, 2 * r));
        g.setStroke(new BasicStroke((float) (s * 0.085), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(new Line2D.Double(cx + r * 0.72, cy + r * 0.72, s * 0.72, s * 0.72));

        // small spark inside the lens
        g.setColor(new Color(255, 255, 255, 200));
        g.fill(new Ellipse2D.Double(cx - r * 0.45, cy - r * 0.45, s * 0.03, s * 0.03));

        g.dispose();
        ImageIO.write(img, "png", out);
    }
}