package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class SearchITWindow {
    private static String currentUser = "";
    private static final Color BG = new Color(0x080d1b);
    private static final Color PANEL = new Color(0x101a30);
    private static final Color CARD = new Color(0x142039);
    private static final Color FIELD = new Color(0x17243b);
    private static final Color BORDER = new Color(0x263653);
    private static final Color ACCENT = new Color(0x38bdf8);
    private static final Color BLUE = new Color(0x2563eb);
    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0xaab6cc);
    private static final String FENCE = "```";

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
frame.getContentPane().setBackground(BG);
frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("SEARCH IT");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(ACCENT);

        JLabel tagline = new JLabel("Search. Discover. Learn.");
        tagline.setForeground(MUTED);
tagline.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel heading = new JPanel(new GridLayout(2, 1));
        heading.setOpaque(false);
        heading.add(title);
        heading.add(tagline);

        JTextField searchField = new JTextField();
        searchField.setBackground(FIELD);
        searchField.setForeground(TEXT);
        searchField.setCaretColor(TEXT);
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        searchField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER), new EmptyBorder(8, 10, 8, 10)));

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(BLUE);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(true);
        searchButton.setBorder(new EmptyBorder(10, 22, 10, 22));

        JPanel searchRow = new JPanel(new BorderLayout(8, 0));
        searchRow.setOpaque(false);
        searchRow.add(searchField, BorderLayout.CENTER);
        searchRow.add(searchButton, BorderLayout.EAST);

        JPanel top = new JPanel(new BorderLayout(0, 16));
top.setBackground(PANEL);
top.setBorder(new EmptyBorder(22, 26, 22, 26));
        top.add(heading, BorderLayout.NORTH);
                String[] categories = {"Programming", "Computer Fundamentals", "Networking",
                "Web Development", "Database Management", "Cybersecurity",
                "Emerging Technologies"};

        JPanel categoryRow = new JPanel();
categoryRow.setLayout(new BoxLayout(categoryRow, BoxLayout.Y_AXIS));
categoryRow.setOpaque(false);

        for (String name : categories) {
            JButton button = new JButton(name);
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
button.setMaximumSize(new Dimension(220, 42));
button.setPreferredSize(new Dimension(220, 42));
button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setBackground(new Color(0x172944));
button.setForeground(TEXT);
button.setFocusPainted(false);
button.setOpaque(true);
button.setCursor(new Cursor(Cursor.HAND_CURSOR));
button.setFont(new Font("SansSerif", Font.PLAIN, 13));

button.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(new Color(0x304568), 1, true),
        new EmptyBorder(10, 14, 10, 14)
));
button.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setBackground(new Color(0x23446b));
        button.setForeground(ACCENT);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        button.setBackground(new Color(0x172944));
        button.setForeground(TEXT);
    }
});
            button.addActionListener(e -> {
                searchField.setText(name);
                searchButton.doClick();
            });
            categoryRow.add(button);
        }

        JPanel searchArea = new JPanel(new BorderLayout());
searchArea.setOpaque(false);
searchArea.add(searchRow, BorderLayout.CENTER);

top.add(searchArea, BorderLayout.CENTER);

// Sidebar navigation
JPanel sidebar = new JPanel(new BorderLayout(0, 12));
sidebar.setBackground(PANEL);
sidebar.setPreferredSize(new Dimension(245, 0));
sidebar.setBorder(new EmptyBorder(18, 12, 18, 12));

JLabel navTitle = new JLabel("EXPLORE TOPICS");
navTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
navTitle.setForeground(ACCENT);

JScrollPane categoryScroll = new JScrollPane(categoryRow);
categoryScroll.setBorder(null);
categoryScroll.getViewport().setBackground(PANEL);
categoryScroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
);

sidebar.add(navTitle, BorderLayout.NORTH);
sidebar.add(categoryScroll, BorderLayout.CENTER);

        DefaultListModel<Article> model = new DefaultListModel<>();
        JList<Article> resultList = new JList<>(model);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.setBackground(CARD);
        resultList.setForeground(TEXT);
        resultList.setFont(new Font("SansSerif", Font.PLAIN, 15));
        resultList.setSelectionBackground(BLUE);
        resultList.setSelectionForeground(Color.WHITE);
        resultList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(((Article) value).getTitle());
                setBorder(new EmptyBorder(8, 10, 8, 10));
                return this;
            }
        });

        HTMLEditorKit kit = new HTMLEditorKit();
        StyleSheet css = kit.getStyleSheet();
        css.addRule("body { font-family: SansSerif; font-size: 14px; color: #e2e8f0; background-color: #0b1220; margin: 14px; }");
        css.addRule("h1 { color: #38bdf8; font-size: 24px; }");
        css.addRule("h2 { color: #a78bfa; font-size: 18px; margin-top: 18px; }");
        css.addRule("h3 { color: #7dd3fc; font-size: 15px; }");
        css.addRule("pre { background-color: #020b04; color: #38bdf8; font-family: Monospaced; font-size: 13px; padding: 8px; }");
        css.addRule("b { color: #ffffff; }");
        css.addRule("li { margin-bottom: 4px; }");

        JEditorPane viewer = new JEditorPane();
        viewer.setEditorKit(kit);
        viewer.setEditable(false);
        viewer.setBackground(new Color(0x0b1220));
        viewer.setText(page("<p>Type a topic and press Search.</p>"));

                CardLayout centerCards = new CardLayout();
        JPanel centerPanel = new JPanel(centerCards);
        centerPanel.setBackground(BG);

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
        };

        searchButton.addActionListener(e -> doSearch.run());
        searchField.addActionListener(e -> doSearch.run());

        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Article a = resultList.getSelectedValue();
                if (a != null) {
                    viewer.setText(page(buildHtml(a)));
                    viewer.setCaretPosition(0);
                }
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
        split.setBackground(BG);
        split.setBorder(new EmptyBorder(12, 12, 12, 12));
                DashboardPanel dashboard = new DashboardPanel(currentUser, manager, categories,
                name -> {
                    searchField.setText(name);
                    searchButton.doClick();
                });
        centerPanel.add(dashboard, "home");
        centerPanel.add(split, "search");
        centerCards.show(centerPanel, "home");

        // Main application layout
JPanel mainContent = new JPanel(new BorderLayout());
mainContent.setBackground(BG);

mainContent.add(sidebar, BorderLayout.WEST);
mainContent.add(centerPanel, BorderLayout.CENTER);

        JPanel userBar = new JPanel(new BorderLayout());
        userBar.setBackground(new Color(0x080d1b));
        userBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));

        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser);
        welcomeLabel.setForeground(new Color(0x38bdf8));
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(0x2563eb));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(ev -> {
            frame.dispose();
            main(new String[0]);
        });

        JButton homeButton = new JButton("Home");
        homeButton.setBackground(new Color(0x172944));
        homeButton.setForeground(new Color(0x38bdf8));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(ev -> centerCards.show(centerPanel, "home"));

        JPanel barButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        barButtons.setOpaque(false);
        barButtons.add(homeButton);
        barButtons.add(logoutButton);

        userBar.add(welcomeLabel, BorderLayout.WEST);
        userBar.add(barButtons, BorderLayout.EAST);

        JPanel northWrap = new JPanel(new BorderLayout());
        northWrap.add(userBar, BorderLayout.NORTH);
        northWrap.add(top, BorderLayout.CENTER);
        frame.add(northWrap, BorderLayout.NORTH);
frame.add(mainContent, BorderLayout.CENTER);

frame.setVisible(true);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

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