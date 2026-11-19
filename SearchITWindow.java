package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class SearchITWindow {

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

        ArticleManager manager = new ArticleManager();
        ArticleData.loadArticles(manager);
        ArticleDataProgramming.load(manager);
        ArticleDataNetworking.load(manager);
        ArticleDataEmerging.load(manager);
        ArticleDataMore.load(manager);

        SwingUtilities.invokeLater(() -> createWindow(manager));
    }

    private static void createWindow(ArticleManager manager) {

        JFrame frame = new JFrame("Search IT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 680);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(BG);

        JLabel title = new JLabel("SEARCH IT");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(ACCENT);

        JLabel tagline = new JLabel("Search. Discover. Learn.");
        tagline.setForeground(MUTED);

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

        JPanel top = new JPanel(new BorderLayout(0, 12));
        top.setBackground(PANEL);
        top.setBorder(new EmptyBorder(14, 16, 14, 16));
        top.add(heading, BorderLayout.NORTH);
                String[] categories = {"Programming", "Computer Fundamentals", "Networking",
                "Web Development", "Database Management", "Cybersecurity",
                "Emerging Technologies"};

        JPanel categoryRow = new JPanel(new GridLayout(2, 4, 8, 8));
        categoryRow.setOpaque(false);

        for (String name : categories) {
            JButton button = new JButton(name);
            button.setBackground(CARD);
            button.setForeground(ACCENT);
            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(BORDER), new EmptyBorder(6, 12, 6, 12)));
            button.addActionListener(e -> {
                searchField.setText(name);
                searchButton.doClick();
            });
            categoryRow.add(button);
        }

        JPanel searchArea = new JPanel(new BorderLayout(0, 8));
        searchArea.setOpaque(false);
        searchArea.add(searchRow, BorderLayout.NORTH);
        searchArea.add(categoryRow, BorderLayout.CENTER);

        top.add(searchArea, BorderLayout.CENTER);

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

        Runnable doSearch = () -> {
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

        JScrollPane viewerScroll = new JScrollPane(viewer);
        viewerScroll.setBorder(new LineBorder(BORDER));

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScroll, viewerScroll);
        split.setDividerLocation(270);
        split.setDividerSize(6);
        split.setContinuousLayout(true);
        split.setBackground(BG);
        split.setBorder(new EmptyBorder(12, 12, 12, 12));

        frame.add(top, BorderLayout.NORTH);
        frame.add(split, BorderLayout.CENTER);
        frame.setVisible(true);
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