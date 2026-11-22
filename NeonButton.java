package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/** A rounded, glowing button. filled = gradient fill, otherwise an outline. */
public class NeonButton extends JButton {

    private final boolean filled;
    private boolean hover;

    public NeonButton(String text, boolean filled) {
        super(text);
        this.filled = filled;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setFont(Fx.heading(Font.BOLD, 11f));
        setForeground(filled ? Color.WHITE : new Color(0x38bdf8));
        setBorder(new EmptyBorder(10, 24, 10, 24));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();

        if (hover) {
            for (int i = 4; i >= 1; i--) {
                g2.setColor(new Color(56, 189, 248, 28));
                g2.setStroke(new BasicStroke(i * 2));
                g2.drawRoundRect(3, 3, w - 6, h - 6, h, h);
            }
        }

        if (filled) {
            Color left = hover ? new Color(0x3b82f6) : new Color(0x2563eb);
            Color right = hover ? new Color(0xa78bfa) : new Color(0x8b5cf6);
            g2.setPaint(new GradientPaint(0, 0, left, w, 0, right));
            g2.fillRoundRect(3, 3, w - 6, h - 6, h, h);
        } else {
            g2.setColor(hover ? new Color(56, 189, 248, 45) : new Color(56, 189, 248, 18));
            g2.fillRoundRect(3, 3, w - 6, h - 6, h, h);
            g2.setColor(new Color(56, 189, 248, hover ? 255 : 150));
            g2.setStroke(new BasicStroke(1.4f));
            g2.drawRoundRect(3, 3, w - 6, h - 6, h, h);
        }
        g2.dispose();
        super.paintComponent(g);
    }
}