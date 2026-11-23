package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.function.Consumer;

public class SearchITWindow {
    private static String currentUser = "";

    private static final Color CARD = new Color(0x142039);
    private static final Color BORDER = new Color(0x263653);
    private static final Color ACCENT = new Color(0x38bdf8);
    private static final Color BLUE = new Color(0x2563eb);
    private static final Color VIOLET = new Color(0x8b5cf6);
    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0xaab6cc);
    private static final String FENCE = "```";

    private static final String[] CATEGORIES = {
        "Programming", "Computer Fundamentals", "Networking",
        "Web Development", "Database Management", "Cybersecurity",
        "Emerging Technologies"
    };

    private static final Color[] GLOWS = {
        new Color(0x38bdf8), new Color(0x8b5cf6), new Color(0x22d3ee),
        new Color(0xa78bfa), new Color(0x60a5fa), new Color(0xc084fc),
        new Color(0x2dd4bf)
    };

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                AccountStore store = new AccountStore();
                new LoginWindow(store, user -> showApp(user)).setVisible(true);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Could not start: " + e.getMessage());
            }
        });
    }

    public static void showApp(String username) {
        currentUser = username;
        ArticleManager manager = new ArticleManager();
        ArticleData.loadArticles(manager);
        ArticleDataProgramming.load(manager);
        ArticleDataNetworking.load(manager);
        ArticleDataEmerging.load(manager);
        ArticleDataMore.load(manager);

        SwingUtilities.invokeLater(() -> createWindow(manager));
    }

    private static void createWindow(ArticleManager manager) {

        JFrame frame = new JFrame("SEARCH IT | IT Learning Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 780);
        frame.setMinimumSize(new Dimension(900, 600));
        frame.setLocationRelativeTo(null);

        Backdrop backdrop = new Backdrop(new BorderLayout());
        frame.setContentPane(backdrop);

        CardLayout centerCards = new CardLayout();
        JPanel centerPanel = new JPanel(centerCards);
        centerPanel.setOpaque(false);

        // ---------- search bar ----------
        HintField searchField = new HintField("Search topics: Java, DNS, blockchain...");
        NeonButton searchButton = new NeonButton("SEARCH", true);
        Pill pill = new Pill();
        pill.setLayout(new BorderLayout(6, 0));
        pill.add(searchField, BorderLayout.CENTER);
        pill.add(searchButton, BorderLayout.EAST);
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                pill.setFocused(true);
                searchField.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                pill.setFocused(false);
                searchField.repaint();
            }
        });

        // ---------- article list and reader ----------
        DefaultListModel<Article> model = new DefaultListModel<>();
        JList<Article> resultList = new JList<>(model);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.setBackground(CARD);
        resultList.setForeground(TEXT);
        resultList.setFont(Fx.body(Font.BOLD, 14f));
        resultList.setSelectionBackground(BLUE);
        resultList.setSelectionForeground(Color.WHITE);
        resultList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((Article) value).getTitle());
                setBorder(new EmptyBorder(9, 12, 9, 12));
                return this;
            }
        });

        String bodyFamily = Fx.body(Font.PLAIN, 14f).getFamily();
        String headFamily = Fx.heading(Font.PLAIN, 14f).getFamily();

        HTMLEditorKit kit = new HTMLEditorKit();
        StyleSheet css = kit.getStyleSheet();
        css.addRule("body { color: #e2e8f0; background-color: #0b1220; margin: 16px; font-size: 17px; }");
        css.addRule("body { font-family: " + bodyFamily + "; }");
        css.addRule("h1 { color: #38bdf8; font-size: 24px; }");
        css.addRule("h1 { font-family: " + headFamily + "; }");
        css.addRule("h2 { color: #a78bfa; font-size: 17px; margin-top: 18px; }");
        css.addRule("h2 { font-family: " + headFamily + "; }");
        css.addRule("h3 { color: #7dd3fc; font-size: 17px; }");
        css.addRule("pre { background-color: #020b04; color: #38bdf8; font-family: Monospaced; font-size: 13px; padding: 8px; }");
        css.addRule("b { color: #ffffff; }");
        css.addRule("li { margin-bottom: 4px; }");

        JEditorPane viewer = new JEditorPane();
        viewer.setEditorKit(kit);
        viewer.setEditable(false);
        viewer.setBackground(new Color(0x0b1220));
        viewer.setText(page("<p>Type a topic and press Search.</p>"));

        Runnable doSearch = () -> {
            centerCards.show(centerPanel, "search");
            model.clear();
            for (Article a : manager.searchArticles(searchField.getText())) {
                model.addElement(a);
            }
            String msg = model.isEmpty()
                    ? "No matching articles found."
                    : model.size() + " result(s) found. Select an article from the list.";
            viewer.setText(page("<p>" + msg + "</p>"));
            if (!model.isEmpty()) {
                resultList.setSelectedIndex(0);
            }
        };

        searchButton.addActionListener(e -> doSearch.run());

        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Article a = resultList.getSelectedValue();
                if (a != null) {
                    viewer.setText(page(buildHtml(a)));
                    viewer.setCaretPosition(0);
                }
            }
        });

        Consumer<Article> openArticle = a -> {
            centerCards.show(centerPanel, "search");
            model.clear();
            model.addElement(a);
            resultList.setSelectedIndex(0);
        };

                // ---------- search suggestions ----------
        DefaultListModel<Article> sugModel = new DefaultListModel<>();
        JList<Article> sugList = new JList<>(sugModel);
        sugList.setFocusable(false);
        sugList.setBackground(new Color(0x0e1830));
        sugList.setForeground(TEXT);
        sugList.setSelectionBackground(BLUE);
        sugList.setSelectionForeground(Color.WHITE);
        sugList.setFont(Fx.body(Font.BOLD, 15f));
        sugList.setFixedCellHeight(38);
        sugList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                Article a = (Article) value;
                setText(a.getTitle() + "   (" + a.getCategory() + ")");
                setBorder(new EmptyBorder(0, 14, 0, 14));
                return this;
            }
        });

        JPopupMenu sugPopup = new JPopupMenu();
        sugPopup.setFocusable(false);
        sugPopup.setBorder(new LineBorder(ACCENT));
        sugPopup.add(sugList);

        Runnable updateSuggestions = () -> {
            String q = searchField.getText().trim().toLowerCase();
            sugModel.clear();
            if (!q.isEmpty()) {
                for (Article a : manager.getAllArticles()) {
                    if (a.getTitle().toLowerCase().contains(q)) {
                        sugModel.addElement(a);
                        if (sugModel.size() >= 6) {
                            break;
                        }
                    }
                }
            }
            if (sugModel.isEmpty() || !searchField.isFocusOwner()) {
                sugPopup.setVisible(false);
            } else {
                sugList.setSelectedIndex(-1);
                sugPopup.setPopupSize(pill.getWidth(), sugModel.size() * 38 + 4);
                if (!sugPopup.isVisible()) {
                    sugPopup.show(pill, 0, pill.getHeight() + 4);
                }
            }
        };

        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions.run();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions.run();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateSuggestions.run();
            }
        });

        searchField.addActionListener(e -> {
            Article picked = sugPopup.isVisible() ? sugList.getSelectedValue() : null;
            sugPopup.setVisible(false);
            if (picked != null) {
                openArticle.accept(picked);
            } else {
                doSearch.run();
            }
        });
        searchButton.addActionListener(e -> sugPopup.setVisible(false));

        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                sugPopup.setVisible(false);
            }
        });

        sugList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                sugList.setSelectedIndex(sugList.locationToIndex(e.getPoint()));
            }
        });
        sugList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int i = sugList.locationToIndex(e.getPoint());
                if (i >= 0) {
                    Article a = sugModel.get(i);
                    sugPopup.setVisible(false);
                    openArticle.accept(a);
                }
            }
        });

        InputMap im = searchField.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = searchField.getActionMap();
        im.put(KeyStroke.getKeyStroke("DOWN"), "sugDown");
        im.put(KeyStroke.getKeyStroke("UP"), "sugUp");
        im.put(KeyStroke.getKeyStroke("ESCAPE"), "sugHide");
        am.put("sugDown", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int n = sugModel.size();
                if (sugPopup.isVisible() && n > 0) {
                    sugList.setSelectedIndex((sugList.getSelectedIndex() + 1) % n);
                }
            }
        });
        am.put("sugUp", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int n = sugModel.size();
                if (sugPopup.isVisible() && n > 0) {
                    int s = sugList.getSelectedIndex();
                    sugList.setSelectedIndex(s <= 0 ? n - 1 : s - 1);
                }
            }
        });
        am.put("sugHide", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                sugPopup.setVisible(false);
            }
        });
        
        JScrollPane listScroll = new JScrollPane(resultList);
        listScroll.setBorder(new LineBorder(BORDER));
        listScroll.getViewport().setBackground(CARD);
        listScroll.setPreferredSize(new Dimension(280, 0));
        listScroll.getVerticalScrollBar().setUnitIncrement(16);

        JScrollPane viewerScroll = new JScrollPane(viewer);
        viewerScroll.setBorder(new LineBorder(BORDER));
        viewerScroll.getVerticalScrollBar().setUnitIncrement(16);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScroll, viewerScroll);
        split.setDividerLocation(270);
        split.setDividerSize(6);
        split.setContinuousLayout(true);
        split.setOpaque(false);
        split.setBorder(new EmptyBorder(14, 14, 14, 14));

        Fx.FadePanel searchView = new Fx.FadePanel(new BorderLayout());
        searchView.setOpaque(false);
        searchView.add(split, BorderLayout.CENTER);

        // ---------- dashboard ----------
        DashboardPanel dashboard = new DashboardPanel(currentUser, manager, CATEGORIES,
                name -> {
                    searchField.setText(name);
                    searchButton.doClick();
                }, openArticle);

                        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Article viewed = resultList.getSelectedValue();
                if (viewed != null) {
                    dashboard.addRecent(viewed);
                }
            }
        });
        
        centerPanel.add(dashboard, "home");
        centerPanel.add(searchView, "search");
        centerCards.show(centerPanel, "home");

        // ---------- header ----------
        JLabel logo = new JLabel("SEARCH IT");
        logo.setFont(Fx.heading(Font.BOLD, 22f));
        logo.setForeground(ACCENT);
        JLabel tag = new JLabel("IT LEARNING PLATFORM");
        tag.setFont(Fx.body(Font.BOLD, 11f));
        tag.setForeground(MUTED);
        JPanel brand = new JPanel(new GridLayout(2, 1));
        brand.setOpaque(false);
        brand.add(logo);
        brand.add(tag);

        JLabel userLabel = new JLabel("Welcome, " + currentUser);
        userLabel.setFont(Fx.body(Font.BOLD, 14f));
        userLabel.setForeground(ACCENT);
        NeonButton homeButton = new NeonButton("HOME", false);
        homeButton.addActionListener(ev -> centerCards.show(centerPanel, "home"));
        NeonButton logoutButton = new NeonButton("LOGOUT", false);
        logoutButton.addActionListener(ev -> {
            frame.dispose();
            main(new String[0]);
        });

        JPanel actions = new JPanel(new GridBagLayout());
        actions.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 10, 0, 0);
        gc.gridx = 0;
        actions.add(userLabel, gc);
        gc.gridx = 1;
        actions.add(homeButton, gc);
        gc.gridx = 2;
        actions.add(logoutButton, gc);

        HeaderPanel header = new HeaderPanel();
        header.setLayout(new BorderLayout(20, 0));
        header.setBorder(new EmptyBorder(12, 24, 14, 24));
        header.add(brand, BorderLayout.WEST);
        header.add(centered(pill), BorderLayout.CENTER);
        header.add(actions, BorderLayout.EAST);

        // ---------- sidebar ----------
        JLabel navTitle = new JLabel("EXPLORE TOPICS");
        navTitle.setFont(Fx.heading(Font.BOLD, 12f));
        navTitle.setForeground(ACCENT);

        JPanel navList = new JPanel(new GridLayout(0, 1, 0, 10));
        navList.setOpaque(false);
        for (int i = 0; i < CATEGORIES.length; i++) {
            String category = CATEGORIES[i];
            int count = 0;
            for (Article a : manager.getAllArticles()) {
                if (a.getCategory().equalsIgnoreCase(category)) {
                    count++;
                }
            }
            NavButton b = new NavButton(category,
                    count + (count == 1 ? " article" : " articles"),
                    GLOWS[i % GLOWS.length]);
            b.addActionListener(e -> {
                searchField.setText(category);
                searchButton.doClick();
            });
            navList.add(b);
        }
        NavButton surprise = new NavButton("Surprise me", "Open a random article", VIOLET);
        surprise.addActionListener(e -> {
            java.util.List<Article> all = manager.getAllArticles();
            if (!all.isEmpty()) {
                openArticle.accept(all.get(new Random().nextInt(all.size())));
            }
        });
        navList.add(surprise);

        SidePanel sidebar = new SidePanel();
        sidebar.setLayout(new BorderLayout(0, 14));
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBorder(new EmptyBorder(20, 16, 20, 16));
        sidebar.add(navTitle, BorderLayout.NORTH);
        sidebar.add(navList, BorderLayout.CENTER);

        // ---------- assemble ----------
        JPanel body = new JPanel(new BorderLayout());
        body.setOpaque(false);
        body.add(sidebar, BorderLayout.WEST);
        body.add(centerPanel, BorderLayout.CENTER);

        backdrop.add(header, BorderLayout.NORTH);
        backdrop.add(body, BorderLayout.CENTER);
        backdrop.setActiveWhen(dashboard::isShowing);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private static JPanel centered(JComponent c) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.CENTER;
        p.add(c, gc);
        return p;
    }

    // ---------- custom components ----------

    /** Text field that shows a hint while it is empty. */
    private static class HintField extends JTextField {
        private final String hint;

        HintField(String hint) {
            this.hint = hint;
            setOpaque(false);
            setForeground(TEXT);
            setCaretColor(ACCENT);
            setFont(Fx.body(Font.PLAIN, 16f));
            setBorder(new EmptyBorder(8, 16, 8, 8));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty() && !isFocusOwner()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.setColor(new Color(0x7f8ea8));
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(hint, getInsets().left,
                        (getHeight() + fm.getAscent() - fm.getDescent()) / 2);
                g2.dispose();
            }
        }
    }

    /** Rounded search bar container that glows when focused. */
    private static class Pill extends JPanel {
        private boolean focused;

        Pill() {
            setOpaque(false);
            setBorder(new EmptyBorder(4, 4, 4, 4));
        }

        void setFocused(boolean focused) {
            this.focused = focused;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 4;
            int h = getHeight() - 4;
            if (focused) {
                for (int i = 5; i >= 1; i--) {
                    g2.setColor(new Color(56, 189, 248, 26));
                    g2.setStroke(new BasicStroke(i * 2));
                    g2.drawRoundRect(2, 2, w, h, h, h);
                }
            }
            g2.setColor(new Color(11, 19, 38, 225));
            g2.fillRoundRect(2, 2, w, h, h, h);
            g2.setColor(new Color(56, 189, 248, focused ? 255 : 120));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(2, 2, w, h, h, h);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** Dark translucent header with a glowing gradient line at the bottom. */
    private static class HeaderPanel extends JPanel {
        HeaderPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            int w = getWidth();
            int h = getHeight();
            if (w <= 0) {
                return;
            }
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(new Color(5, 8, 22, 185));
            g2.fillRect(0, 0, w, h);
            float[] stops = {0f, 0.5f, 1f};
            g2.setPaint(new LinearGradientPaint(0, 0, w, 0, stops, new Color[]{
                new Color(56, 189, 248, 70), new Color(139, 92, 246, 70), new Color(34, 211, 238, 70)}));
            g2.fillRect(0, h - 8, w, 6);
            g2.setPaint(new LinearGradientPaint(0, 0, w, 0, stops, new Color[]{
                new Color(0x38bdf8), new Color(0x8b5cf6), new Color(0x22d3ee)}));
            g2.fillRect(0, h - 2, w, 2);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** Dark translucent sidebar with a thin glowing edge. */
    private static class SidePanel extends JPanel {
        SidePanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(new Color(5, 8, 22, 160));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(new Color(56, 189, 248, 70));
            g2.fillRect(getWidth() - 1, 0, 1, getHeight());
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** Large glowing sidebar button with a title and a small caption. */
    private static class NavButton extends JButton {
        private final String name;
        private final String sub;
        private final Color glow;
        private final Font subFont = Fx.body(Font.PLAIN, 12f);
        private boolean hover;
        private int fitWidth = -1;
        private Font fitFont;

        NavButton(String name, String sub, Color glow) {
            this.name = name;
            this.sub = sub;
            this.glow = glow;
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
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

        private Font fit(Graphics2D g2, int maxWidth) {
            float size = 13f;
            Font f = Fx.heading(Font.BOLD, size);
            while (size > 8f && g2.getFontMetrics(f).stringWidth(name) > maxWidth) {
                size -= 0.5f;
                f = Fx.heading(Font.BOLD, size);
            }
            return f;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int w = getWidth();
            int h = getHeight();

            if (hover) {
                for (int i = 4; i >= 1; i--) {
                    g2.setColor(new Color(glow.getRed(), glow.getGreen(), glow.getBlue(), 28));
                    g2.setStroke(new BasicStroke(i * 2));
                    g2.drawRoundRect(4, 4, w - 8, h - 8, 18, 18);
                }
            }

            g2.setColor(hover ? new Color(27, 47, 82, 240) : new Color(16, 27, 51, 205));
            g2.fillRoundRect(4, 4, w - 8, h - 8, 18, 18);

            g2.setColor(glow);
            g2.fillRoundRect(4, 12, 4, Math.max(8, h - 24), 4, 4);

            g2.setColor(new Color(glow.getRed(), glow.getGreen(), glow.getBlue(),
                    hover ? 255 : 110));
            g2.setStroke(new BasicStroke(1.3f));
            g2.drawRoundRect(4, 4, w - 8, h - 8, 18, 18);

            int avail = w - 52;
            if (fitFont == null || fitWidth != avail) {
                fitFont = fit(g2, avail);
                fitWidth = avail;
            }
            int cy = h / 2;
            g2.setFont(fitFont);
            g2.setColor(hover ? glow : TEXT);
            g2.drawString(name, 22, cy - 2);
            g2.setFont(subFont);
            g2.setColor(MUTED);
            g2.drawString(sub, 22, cy + 16);
            g2.dispose();
        }
    }

    // ---------- article formatting ----------

    private static String page(String body) {
        return "<html><body>" + body + "</body></html>";
    }

    private static String buildHtml(Article a) {

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append(escape(a.getTitle())).append("</h1>");
        sb.append("<p><b>Category:</b> ").append(escape(a.getCategory())).append("</p>");
        sb.append("<p>").append(escape(a.getDescription())).append("</p>");

        if (!a.getSections().isEmpty()) {
            int n = 1;
            for (Section s : a.getSections()) {
                block(sb, n++, s.getTitle(), s.getContent());
            }
        } else {
            block(sb, 1, "Introduction", a.getDefinition());
            block(sb, 2, "History", a.getHistory());
            block(sb, 3, "Core Concepts", a.getCoreConcepts());
            block(sb, 4, "How It Works", a.getHowItWorks());
            block(sb, 5, "Types", a.getTypes());
            block(sb, 6, "Examples", a.getExamples());
            block(sb, 7, "Applications", a.getApplications());
            block(sb, 8, "Advantages", a.getAdvantages());
            block(sb, 9, "Limitations", a.getLimitations());
            block(sb, 10, "Related Topics", a.getRelatedTopics());
        }

        sb.append("<h2>References</h2><ul>");
        for (String ref : a.getReferences()) {
            sb.append("<li>").append(escape(ref)).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    private static void block(StringBuilder sb, int number, String title, String text) {
        sb.append("<h2>").append(number).append(". ").append(escape(title)).append("</h2>");
        sb.append(renderContent(text));
    }

    private static String renderContent(String text) {

        String[] parts = text.split(FENCE, -1);
        StringBuilder html = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i % 2 == 1) {
                String code = parts[i];
                int nl = code.indexOf('\n');
                if (nl != -1 && code.substring(0, nl).trim().matches("[a-zA-Z]+")) {
                    code = code.substring(nl + 1);
                }
                code = code.replaceAll("^\\n|\\n$", "");
                html.append("<pre>").append(escape(code)).append("</pre>");
            } else {
                html.append(renderText(parts[i]));
            }
        }
        return html.toString();
    }

    private static String renderText(String text) {

        StringBuilder html = new StringBuilder();
        String list = null;

        for (String raw : text.split("\n")) {
            String line = raw.trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("### ")) {
                list = closeList(html, list);
                html.append("<h3>").append(fmt(line.substring(4))).append("</h3>");
            } else if (line.startsWith("- ")) {
                if (!"ul".equals(list)) {
                    closeList(html, list);
                    html.append("<ul>");
                    list = "ul";
                }
                html.append("<li>").append(fmt(line.substring(2))).append("</li>");
            } else if (line.matches("^\\d+\\.\\s.*")) {
                if (!"ol".equals(list)) {
                    closeList(html, list);
                    html.append("<ol>");
                    list = "ol";
                }
                html.append("<li>").append(fmt(line.replaceFirst("^\\d+\\.\\s", ""))).append("</li>");
            } else {
                list = closeList(html, list);
                html.append("<p>").append(fmt(line)).append("</p>");
            }
        }

        closeList(html, list);
        return html.toString();
    }

    private static String closeList(StringBuilder html, String list) {
        if (list != null) {
            html.append("</").append(list).append(">");
        }
        return null;
    }

    private static String fmt(String s) {
        return escape(s).replaceAll("\\*\\*(.+?)\\*\\*", "<b>$1</b>");
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}