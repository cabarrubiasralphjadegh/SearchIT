package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashboardPanel extends JPanel {

    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0xaab6cc);
    private static final Color VIOLET = new Color(0x8b5cf6);
    private static final Color[] GLOWS = {
        new Color(0x38bdf8), new Color(0x8b5cf6), new Color(0x22d3ee),
        new Color(0xa78bfa), new Color(0x60a5fa), new Color(0xc084fc),
        new Color(0x2dd4bf)
    };

    private final List<GlowCard> cards = new ArrayList<>();
    private final List<JLabel> statLabels = new ArrayList<>();
    private final List<Integer> statTargets = new ArrayList<>();
    private final JLabel sub = new JLabel(" ");
    private final String subText =
            "Search. Discover. Learn. Pick a topic below, or type in the search bar above.";

    public DashboardPanel(String username, ArticleManager manager,
                          String[] categories, Consumer<String> onCategory) {
        this(username, manager, categories, onCategory, a -> { });
    }

    public DashboardPanel(String username, ArticleManager manager, String[] categories,
                          Consumer<String> onCategory, Consumer<Article> onOpen) {

        setOpaque(false);
        setLayout(new BorderLayout());

        List<Article> all = manager.getAllArticles();
        int refs = 0;
        for (Article a : all) {
            refs += a.getReferences().size();
        }

        // Welcome banner
        GlowCard banner = new GlowCard(GLOWS[0]);
        cards.add(banner);
        banner.setLayout(new GridLayout(0, 1, 0, 6));
        JLabel hello = new JLabel("<html>Welcome back, <font color='#38bdf8'>"
                + esc(username) + "</font></html>");
        hello.setOpaque(false);
        hello.setFont(Fx.heading(Font.BOLD, 24f));
        hello.setForeground(TEXT);
        sub.setFont(Fx.body(Font.PLAIN, 14f));
        sub.setForeground(MUTED);
        banner.add(hello);
        banner.add(sub);

        // Statistics cards
        JPanel stats = new JPanel(new GridLayout(1, 3, 14, 14));
        stats.setOpaque(false);
        stats.add(stat(all.size(), "Articles", GLOWS[0]));
        stats.add(stat(categories.length, "Categories", GLOWS[1]));
        stats.add(stat(refs, "Reference links", GLOWS[2]));

        // Category cards plus two action cards = a full 3 x 3 grid
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
            grid.add(card(name, count + (count == 1 ? " article" : " articles"),
                    GLOWS[i % GLOWS.length], () -> onCategory.accept(name)));
        }

        Article start = manager.getArticleByTitle("Introduction to Programming");
        if (start == null && !all.isEmpty()) {
            start = all.get(0);
        }
        final Article startArticle = start;
        grid.add(card("Start here",
                startArticle == null ? "Begin learning" : startArticle.getTitle(),
                VIOLET, () -> {
                    if (startArticle != null) {
                        onOpen.accept(startArticle);
                    }
                }));

        Random rnd = new Random();
        grid.add(card("Surprise me", "Open a random article", GLOWS[2], () -> {
            if (!all.isEmpty()) {
                onOpen.accept(all.get(rnd.nextInt(all.size())));
            }
        }));

        JLabel heading = new JLabel("BROWSE BY CATEGORY");
        heading.setFont(Fx.heading(Font.BOLD, 15f));
        heading.setForeground(new Color(0x38bdf8));

        ScrollContent content = new ScrollContent();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(22, 26, 22, 26));

        content.add(fullWidth(banner));
        content.add(Box.createVerticalStrut(16));
        content.add(fullWidth(stats));
        content.add(Box.createVerticalStrut(24));
        content.add(fullWidth(heading));
        content.add(Box.createVerticalStrut(10));
        content.add(fullWidth(grid));

        JScrollPane scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        // Replay the intro animation every time the dashboard is shown
        Fx.onShow(this, () -> {
            scroll.getVerticalScrollBar().setValue(0);
            playIntro();
        });
    }

    private void playIntro() {
        // Cards fade and slide in one after another
        for (int i = 0; i < cards.size(); i++) {
            GlowCard c = cards.get(i);
            c.setAlpha(0f);
            Fx.later(60 * i, () -> Fx.animate(450, p -> c.setAlpha((float) p)));
        }

        // Numbers count up
        for (int i = 0; i < statLabels.size(); i++) {
            JLabel l = statLabels.get(i);
            int target = statTargets.get(i);
            l.setText("0");
            Fx.later(200, () -> Fx.animate(1100,
                    p -> l.setText(String.valueOf((int) Math.round(target * p)))));
        }

        // Welcome line types itself out
        sub.setText(" ");
        Fx.later(300, () -> Fx.animate(1500, p -> {
            int n = (int) Math.round(subText.length() * p);
            sub.setText(n == 0 ? " " : subText.substring(0, n));
        }));
    }

    private GlowCard card(String title, String subtitle, Color glow, Runnable onClick) {
        GlowCard card = new GlowCard(glow);
        cards.add(card);
        card.setLayout(new GridLayout(0, 1, 0, 4));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel n = new JLabel(title);
        n.setFont(Fx.heading(Font.BOLD, 13f));
        n.setForeground(TEXT);
        JLabel c = new JLabel(subtitle);
        c.setFont(Fx.body(Font.PLAIN, 13f));
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
                onClick.run();
            }
        });
        return card;
    }

    private JComponent stat(int target, String label, Color glow) {
        GlowCard card = new GlowCard(glow);
        cards.add(card);
        card.setLayout(new GridLayout(0, 1, 0, 2));
        JLabel big = new JLabel(String.valueOf(target));
        big.setFont(Fx.heading(Font.BOLD, 30f));
        big.setForeground(glow);
        JLabel small = new JLabel(label);
        small.setFont(Fx.body(Font.PLAIN, 13f));
        small.setForeground(MUTED);
        card.add(big);
        card.add(small);
        statLabels.add(big);
        statTargets.add(target);
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

    // Glass-like rounded card with a neon glow that brightens on hover and fades in
    private static class GlowCard extends JPanel {
        private final Color glow;
        private boolean hover;
        private float alpha = 0f;

        GlowCard(Color glow) {
            this.glow = glow;
            setOpaque(false);
            setBorder(new EmptyBorder(18, 22, 18, 22));
        }

        void setHover(boolean hover) {
            this.hover = hover;
            repaint();
        }

        void setAlpha(float a) {
            this.alpha = Math.max(0f, Math.min(1f, a));
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
            g2.translate(0, (1 - alpha) * 14);
            super.paint(g2);
            g2.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 12;
            int h = getHeight() - 12;
            int a = hover ? 34 : 12;

            for (int i = 4; i >= 1; i--) {
                g2.setColor(new Color(glow.getRed(), glow.getGreen(), glow.getBlue(), a));
                g2.setStroke(new BasicStroke(i * 2));
                g2.drawRoundRect(6, 6, w, h, 24, 24);
            }

            g2.setColor(hover ? new Color(26, 43, 74, 235) : new Color(16, 27, 51, 205));
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