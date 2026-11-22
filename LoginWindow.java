package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginWindow extends JFrame {

    private static final Color BG = new Color(0x080d1b);
    private static final Color CARD = new Color(0x142039);
    private static final Color ACCENT = new Color(0x38bdf8);
    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0x94a3b8);

    private final AccountStore store;
    private final Consumer<String> onSuccess;
    private final CardLayout cards = new CardLayout();
    private final JPanel cardPanel = new JPanel(cards);

    private final JTextField loginUser = field(new JTextField());
    private final JPasswordField loginPass = field(new JPasswordField());
    private final JLabel loginMsg = new JLabel(" ");

    private final JTextField regUser = field(new JTextField());
    private final JTextField regEmail = field(new JTextField());
    private final JPasswordField regPass = field(new JPasswordField());
    private final JPasswordField regPass2 = field(new JPasswordField());
    private final JLabel regMsg = new JLabel(" ");

    public LoginWindow(AccountStore store, Consumer<String> onSuccess) {
        this.store = store;
        this.onSuccess = onSuccess;

        setTitle("Search IT - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(560, 700);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(BG);

        cardPanel.setOpaque(false);
        cardPanel.add(buildLogin(), "login");
        cardPanel.add(buildRegister(), "register");
        root.add(cardPanel);

        setContentPane(root);
    }

    // ---------- screens ----------

    private JPanel buildLogin() {
        GlowPanel p = new GlowPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        put(p, title("Welcome back"));
        put(p, small("Log in to continue to Search IT"));
        p.add(Box.createVerticalStrut(20));
        put(p, small("Username or email"));
        put(p, loginUser);
        p.add(Box.createVerticalStrut(12));
        put(p, small("Password"));
        put(p, loginPass);
        p.add(Box.createVerticalStrut(8));
        put(p, loginMsg);
        p.add(Box.createVerticalStrut(8));

        JButton go = primary("Log in");
        go.addActionListener(e -> doLogin());
        loginPass.addActionListener(e -> doLogin());
        put(p, go);

        p.add(Box.createVerticalStrut(10));
        JButton toRegister = link("No account yet? Create one");
        toRegister.addActionListener(e -> {
            regMsg.setText(" ");
            cards.show(cardPanel, "register");
        });
        put(p, toRegister);
        return p;
    }

    private JPanel buildRegister() {
        GlowPanel p = new GlowPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        put(p, title("Create account"));
        put(p, small("Join Search IT in a few seconds"));
        p.add(Box.createVerticalStrut(16));
        put(p, small("Username (letters, numbers, _ ; min 3)"));
        put(p, regUser);
        p.add(Box.createVerticalStrut(10));
        put(p, small("Email"));
        put(p, regEmail);
        p.add(Box.createVerticalStrut(10));
        put(p, small("Password (min 8 characters)"));
        put(p, regPass);
        p.add(Box.createVerticalStrut(10));
        put(p, small("Confirm password"));
        put(p, regPass2);
        p.add(Box.createVerticalStrut(8));
        put(p, regMsg);
        p.add(Box.createVerticalStrut(8));

        JButton go = primary("Create account");
        go.addActionListener(e -> doRegister());
        regPass2.addActionListener(e -> doRegister());
        put(p, go);

        p.add(Box.createVerticalStrut(10));
        JButton back = link("Already have an account? Log in");
        back.addActionListener(e -> {
            loginMsg.setText(" ");
            cards.show(cardPanel, "login");
        });
        put(p, back);
        return p;
    }

    // ---------- actions ----------

    private void doLogin() {
        String user = loginUser.getText().trim();
        char[] pass = loginPass.getPassword();
        try {
            if (user.isEmpty() || pass.length == 0) {
                showMsg(loginMsg, "Enter your username and password.", false);
                return;
            }
            if (store.authenticate(user, pass)) {
                dispose();
                onSuccess.accept(user);
            } else {
                showMsg(loginMsg, "Wrong username/email or password.", false);
            }
        } catch (Exception ex) {
            showMsg(loginMsg, "Login error: " + ex.getMessage(), false);
        } finally {
            Arrays.fill(pass, ' ');
        }
    }

    private void doRegister() {
        String user = regUser.getText().trim();
        String email = regEmail.getText().trim();
        char[] p1 = regPass.getPassword();
        char[] p2 = regPass2.getPassword();
        try {
            if (!user.matches("[A-Za-z0-9_]{3,20}")) {
                showMsg(regMsg, "Username: 3-20 letters, numbers or _ only.", false);
            } else if (!email.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
                showMsg(regMsg, "Please enter a valid email.", false);
            } else if (p1.length < 8) {
                showMsg(regMsg, "Password needs at least 8 characters.", false);
            } else if (!Arrays.equals(p1, p2)) {
                showMsg(regMsg, "Passwords do not match.", false);
            } else if (store.register(user, email, p1)) {
                regUser.setText("");
                regEmail.setText("");
                regPass.setText("");
                regPass2.setText("");
                cards.show(cardPanel, "login");
                loginUser.setText(user);
                showMsg(loginMsg, "Account created. You can log in now.", true);
            } else {
                showMsg(regMsg, "That username or email is already used.", false);
            }
        } catch (Exception ex) {
            showMsg(regMsg, "Error: " + ex.getMessage(), false);
        } finally {
            Arrays.fill(p1, ' ');
            Arrays.fill(p2, ' ');
        }
    }

    private void showMsg(JLabel label, String text, boolean ok) {
        label.setForeground(ok ? new Color(0x34d399) : new Color(0xf87171));
        label.setText(text);
    }

    // ---------- styling helpers ----------

    private static <T extends JTextField> T field(T f) {
        f.setBackground(new Color(0x0b1326));
        f.setForeground(TEXT);
        f.setCaretColor(ACCENT);
        f.setFont(Fx.body(Font.PLAIN, 15f));
        f.setBorder(BorderFactoryHelper.input());
        return f;
    }

    private static JLabel title(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Fx.heading(Font.BOLD, 24f));
        l.setForeground(TEXT);
        return l;
    }

    private static JLabel small(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Fx.body(Font.PLAIN, 13f));
        l.setForeground(MUTED);
        return l;
    }

    private static JButton primary(String text) {
        JButton b = new JButton(text);
        b.setBackground(ACCENT);
        b.setForeground(BG);
        b.setFont(Fx.body(Font.BOLD, 15f));
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorder(new EmptyBorder(10, 16, 10, 16));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private static JButton link(String text) {
        JButton b = new JButton(text);
        b.setForeground(ACCENT);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private static void put(JPanel p, JComponent c) {
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
        if (c instanceof JTextField) {
            c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        } else if (c instanceof JButton) {
            c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        }
        p.add(c);
    }

    private static class BorderFactoryHelper {
        static javax.swing.border.Border input() {
            return BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0x25365a), 1, true),
                new EmptyBorder(8, 10, 8, 10));
        }
    }

    // Rounded card with a soft neon glow
    private static class GlowPanel extends JPanel {
        GlowPanel() {
            setOpaque(false);
            setBorder(new EmptyBorder(36, 40, 36, 40));
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();
            d.width = 440;
            return d;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 16;
            int h = getHeight() - 16;
            for (int i = 7; i >= 1; i--) {
                g2.setColor(new Color(56, 189, 248, 12));
                g2.setStroke(new BasicStroke(i * 2));
                g2.drawRoundRect(8, 8, w, h, 28, 28);
            }
            g2.setColor(CARD);
            g2.fillRoundRect(8, 8, w, h, 28, 28);
            g2.setColor(ACCENT);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(8, 8, w, h, 28, 28);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // ---------- temporary test launcher ----------

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                AccountStore store = new AccountStore();
                new LoginWindow(store, user ->
                    JOptionPane.showMessageDialog(null,
                        "Welcome, " + user + "! (dashboard comes next)")
                ).setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                    "Could not start: " + e.getMessage());
            }
        });
    }
}