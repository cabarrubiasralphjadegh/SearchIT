package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashboardPanel extends JPanel {

    private static final Color BG = new Color(0x080d1b);
    private static final Color CARD = new Color(0x142039);
    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0xaab6cc);
    private static final Color[] GLOWS = {
        new Color(0x38bdf8), new Color(0x8b5cf6), new Color(0x22d3ee),
        new Color(0xa78bfa), new Color(0x60a5fa), new Color(0xc084fc),
        new Color(0x2dd4bf)
    };

    public DashboardPanel(String username, ArticleManager manager,
                          String[] categories, Consumer<String> onCategory) {

        setLayout(new BorderLayout());
        setBackground(BG);

        List<Article> all = manager.getAllArticles();
        int refs = 0;
        for (Article a : all) {
            refs += a.getReferences().size();
        }

        // Welcome banner
        GlowCard banner = new GlowCard(GLOWS[0]);
        banner.setLayout(new GridLayout(0, 1, 0, 6));
        JLabel hello = new JLabel("<html>Welcome back, <font color='#38bdf8'>"
                + esc(username) + "</font></html>");
        hello.setFont(new Font("SansSerif", Font.BOLD, 28));
        hello.setForeground(TEXT);
        JLabel sub = new JLabel(
                "Search. Discover. Learn. Pick a topic below, or type in the search bar above.");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 14));
        sub.setForeground(MUTED);
        banner.add(hello);
        banner.add(sub);

        // Statistics cards
        JPanel stats = new JPanel(new GridLayout(1, 3, 14, 14));
        stats.setOpaque(false);
        stats.add(stat(String.valueOf(all.size()), "Articles", GLOWS[0]));
        stats.add(stat(String.valueOf(categories.length), "Categories", GLOWS[1]));
        stats.add(stat(String.valueOf(refs), "Reference links", GLOWS[2]));

        // Category cards
        JPanel grid = new JPanel(new GridLayout(0, 3, 14, 14));
        grid.setOpaque(false);

        for (int i = 0; i < categories.length; i++) {
            String name = categories[i];
            int count = 0;
            for (Article a : all) {
                if (a.getCategory().equalsIgnoreCase(name)) {
                    count++;
                }
            }

            GlowCard card = new GlowCard(GLOWS[i % GLOWS.length]);
            card.setLayout(new GridLayout(0, 1, 0, 4));
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            JLabel n = new JLabel(name);
            n.setFont(new Font("SansSerif", Font.BOLD, 16));
            n.setForeground(TEXT);
            JLabel c = new JLabel(count + (count == 1 ? " article" : " articles"));
            c.setFont(new Font("SansSerif", Font.PLAIN, 13));
            c.setForeground(MUTED);
            card.add(n);
            card.add(c);

            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    card.setHover(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    card.setHover(false);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    onCategory.accept(name);
                }
            });
            grid.add(card);
        }

        JLabel heading = new JLabel("Browse by category");
        heading.setFont(new Font("SansSerif", Font.BOLD, 18));
        heading.setForeground(new Color(0x38bdf8));

        ScrollContent content = new ScrollContent();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(BG);
        content.setBorder(new EmptyBorder(24, 28, 24, 28));

        content.add(fullWidth(banner));
        content.add(Box.createVerticalStrut(16));
        content.add(fullWidth(stats));
        content.add(Box.createVerticalStrut(26));
        content.add(fullWidth(heading));
        content.add(Box.createVerticalStrut(10));
        content.add(fullWidth(grid));

        JScrollPane scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(BG);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
        SwingUtilities.invokeLater(() -> scroll.getVerticalScrollBar().setValue(0));
    }

    private static JComponent stat(String number, String label, Color glow) {
        GlowCard card = new GlowCard(glow);
        card.setLayout(new GridLayout(0, 1, 0, 2));
        JLabel big = new JLabel(number);
        big.setFont(new Font("SansSerif", Font.BOLD, 34));
        big.setForeground(glow);
        JLabel small = new JLabel(label);
        small.setFont(new Font("SansSerif", Font.PLAIN, 13));
        small.setForeground(MUTED);
        card.add(big);
        card.add(small);
        return card;
    }

    private static JComponent fullWidth(JComponent c) {
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
        c.setMaximumSize(new Dimension(Integer.MAX_VALUE, c.getPreferredSize().height));
        return c;
    }

    private static String esc(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    // Rounded card with a neon glow that brightens on hover
    private static class GlowCard extends JPanel {
        private final Color glow;
        private boolean hover;

        GlowCard(Color glow) {
            this.glow = glow;
            setOpaque(false);
            setBorder(new EmptyBorder(20, 24, 20, 24));
        }

        void setHover(boolean hover) {
            this.hover = hover;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 12;
            int h = getHeight() - 12;
            int alpha = hover ? 34 : 12;

            for (int i = 6; i >= 1; i--) {
                g2.setColor(new Color(glow.getRed(), glow.getGreen(), glow.getBlue(), alpha));
                g2.setStroke(new BasicStroke(i * 2));
                g2.drawRoundRect(6, 6, w, h, 24, 24);
            }

            g2.setColor(hover ? new Color(0x1a2b4a) : CARD);
            g2.fillRoundRect(6, 6, w, h, 24, 24);

            g2.setColor(new Color(glow.getRed(), glow.getGreen(), glow.getBlue(),
                    hover ? 255 : 150));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(6, 6, w, h, 24, 24);

            g2.dispose();
            super.paintComponent(g);
        }
    }

    // A panel that always matches the width of the scroll area
    private static class ScrollContent extends JPanel implements Scrollable {
        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle r, int orientation, int direction) {
            return 16;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle r, int orientation, int direction) {
            return 100;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }
}