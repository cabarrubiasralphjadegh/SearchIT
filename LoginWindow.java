package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.function.Consumer;

public class LoginWindow extends JFrame {

    private static final Color ACCENT = new Color(0x38bdf8);
    private static final Color TEXT = new Color(0xe2e8f0);
    private static final Color MUTED = new Color(0xaab6cc);
    private static final Color GOOD = new Color(0x34d399);
    private static final Color BAD = new Color(0xfb7185);

    /** Current light colour of the lamp; the card, boxes and labels follow it. */
    private static Color accentNow = ACCENT;

    private final AccountStore store;
    private final Consumer<String> onSuccess;

    private final JTextField userField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JPasswordField passField = new JPasswordField();

    private final JLabel logo = new JLabel("SEARCH IT", SwingConstants.CENTER);
    private final JLabel title = new JLabel();
    private final JLabel subtitle = new JLabel();
    private final JLabel userLabel = label("USERNAME OR EMAIL");
    private final JLabel emailLabel = label("EMAIL");
    private final JLabel passLabel = label("PASSWORD");
    private final JLabel message = new JLabel(" ");
    private final NeonButton submit = new NeonButton("LOG IN", true);
    private final JButton toggle = new JButton();

    private final JPanel emailRow;
    private final FadeHolder holder;
    private final LampScene scene;
    private boolean registerMode = false;

    public LoginWindow(AccountStore store, Consumer<String> onSuccess) {
        super("Search IT - Login");
        this.store = store;
        this.onSuccess = onSuccess;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 780);
        setMinimumSize(new Dimension(900, 620));
        setLocationRelativeTo(null);

        scene = new LampScene(new GridBagLayout());
        setContentPane(scene);

        // ----- text styles -----
        logo.setFont(Fx.heading(Font.BOLD, 34f));
        logo.setForeground(ACCENT);

        JLabel tag = new JLabel("IT LEARNING AND RESOURCE DISCOVERY PLATFORM", SwingConstants.CENTER);
        tag.setFont(Fx.body(Font.BOLD, 12f));
        tag.setForeground(MUTED);

        title.setFont(Fx.heading(Font.BOLD, 22f));
        title.setForeground(Color.WHITE);
        subtitle.setFont(Fx.body(Font.PLAIN, 15f));
        subtitle.setForeground(MUTED);
        message.setFont(Fx.body(Font.BOLD, 14f));

        styleField(userField);
        styleField(emailField);
        styleField(passField);

        JPanel userRow = box(userField);
        emailRow = box(emailField);
        JPanel passRow = box(passField);

        submit.setPreferredSize(new Dimension(100, 48));
        submit.addActionListener(e -> submit());
        userField.addActionListener(e -> submit());
        emailField.addActionListener(e -> submit());
        passField.addActionListener(e -> submit());

        toggle.setContentAreaFilled(false);
        toggle.setBorderPainted(false);
        toggle.setFocusPainted(false);
        toggle.setOpaque(false);
        toggle.setForeground(ACCENT);
        toggle.setFont(Fx.body(Font.BOLD, 15f));
        toggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toggle.addActionListener(e -> {
            setMode(!registerMode);
            showMessage(" ", true);
        });

        // ----- card layout -----
        GlassCard card = new GlassCard();
        card.setLayout(new GridBagLayout());
        card.setBorder(new EmptyBorder(34, 40, 30, 40));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;

        int row = 0;
        c.gridy = row++;
        card.add(logo, c);
        c.gridy = row++;
        c.insets = new Insets(2, 0, 22, 0);
        card.add(tag, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridy = row++;
        card.add(title, c);
        c.gridy = row++;
        c.insets = new Insets(2, 0, 20, 0);
        card.add(subtitle, c);

        c.insets = new Insets(0, 0, 6, 0);
        c.gridy = row++;
        card.add(userLabel, c);
        c.insets = new Insets(0, 0, 14, 0);
        c.gridy = row++;
        card.add(userRow, c);

        c.insets = new Insets(0, 0, 6, 0);
        c.gridy = row++;
        card.add(emailLabel, c);
        c.insets = new Insets(0, 0, 14, 0);
        c.gridy = row++;
        card.add(emailRow, c);

        c.insets = new Insets(0, 0, 6, 0);
        c.gridy = row++;
        card.add(passLabel, c);
        c.insets = new Insets(0, 0, 10, 0);
        c.gridy = row++;
        card.add(passRow, c);

        c.insets = new Insets(0, 0, 12, 0);
        c.gridy = row++;
        card.add(message, c);

        c.insets = new Insets(0, 0, 8, 0);
        c.gridy = row++;
        card.add(submit, c);

        c.insets = new Insets(4, 0, 0, 0);
        c.gridy = row++;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        card.add(toggle, c);

        holder = new FadeHolder();
        holder.setLayout(new BorderLayout());
        holder.setBorder(new EmptyBorder(26, 26, 26, 26));
        holder.add(card, BorderLayout.CENTER);
        holder.setPreferredSize(new Dimension(540, holder.getPreferredSize().height));
        holder.setVisible(false);

        // left half is the lamp, right half holds the card
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        filler.setPreferredSize(new Dimension(1, 1));

        GridBagConstraints gl = new GridBagConstraints();
        gl.gridx = 0;
        gl.weightx = 1;
        gl.weighty = 1;
        gl.fill = GridBagConstraints.BOTH;
        scene.add(filler, gl);

        GridBagConstraints gr = new GridBagConstraints();
        gr.gridx = 1;
        gr.weightx = 1;
        gr.weighty = 1;
        gr.anchor = GridBagConstraints.CENTER;
        scene.add(holder, gr);

        // ----- lamp events -----
        scene.setOnTheme(this::recolor);
        scene.setOnToggle(on -> {
            if (on) {
                holder.setVisible(true);
                Fx.later(250, () -> {
                    Fx.animate(600, t -> holder.setAlpha((float) t));
                    userField.requestFocusInWindow();
                });
            } else {
                Fx.animate(400, t -> holder.setAlpha((float) (1 - t)));
                Fx.later(430, () -> {
                    if (!scene.isLit()) {
                        holder.setVisible(false);
                    }
                });
            }
        });

        setMode(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // ---------- behaviour ----------

    private void recolor(Color c) {
        accentNow = c;
        logo.setForeground(c);
        userLabel.setForeground(c);
        emailLabel.setForeground(c);
        passLabel.setForeground(c);
        toggle.setForeground(c);
        holder.repaint();
    }

    private void setMode(boolean register) {
        registerMode = register;
        title.setText(register ? "Create account" : "Welcome back");
        subtitle.setText(register ? "Join Search IT in a few seconds"
                                  : "The light's on. Log in to continue.");
        userLabel.setText(register ? "USERNAME" : "USERNAME OR EMAIL");
        emailLabel.setVisible(register);
        emailRow.setVisible(register);
        submit.setText(register ? "CREATE ACCOUNT" : "LOG IN");
        toggle.setText(register ? "Already have an account? Log in"
                                : "No account yet? Create one");
        revalidate();
        repaint();
    }

    private void showMessage(String text, boolean good) {
        message.setForeground(good ? GOOD : BAD);
        message.setText("<html><div style='width:340px'>" + text + "</div></html>");
    }

    private void submit() {
        String user = userField.getText().trim();
        char[] pw = passField.getPassword();
        try {
            if (registerMode) {
                boolean ok = store.register(user, emailField.getText().trim(), pw);
                if (ok) {
                    passField.setText("");
                    setMode(false);
                    showMessage("Account created. You can log in now.", true);
                } else {
                    showMessage("That username or email is already taken.", false);
                }
            } else if (user.isEmpty() || pw.length == 0) {
                showMessage("Please enter your username and password.", false);
            } else if (store.authenticate(user, pw)) {
                dispose();
                onSuccess.accept(user);
            } else {
                showMessage("Wrong username or password.", false);
            }
        } catch (Exception ex) {
            showMessage(ex.getMessage() == null ? "Something went wrong." : ex.getMessage(), false);
        } finally {
            Arrays.fill(pw, '\0');
        }
    }

    // ---------- small helpers ----------

    private static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Fx.body(Font.BOLD, 12f));
        l.setForeground(ACCENT);
        return l;
    }

    private static void styleField(JTextField f) {
        f.setOpaque(false);
        f.setForeground(TEXT);
        f.setCaretColor(ACCENT);
        f.setFont(Fx.body(Font.PLAIN, 17f));
        f.setBorder(new EmptyBorder(10, 14, 10, 14));
    }

    /** Rounded dark box around a field that glows while the field has focus. */
    private static JPanel box(JTextField field) {
        FieldBox b = new FieldBox();
        b.setLayout(new BorderLayout());
        b.add(field, BorderLayout.CENTER);
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                b.setFocused(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                b.setFocused(false);
            }
        });
        return b;
    }

    /** Panel that can be faded in and out by changing its alpha. */
    private static class FadeHolder extends JPanel {
        private float alpha = 0f;

        FadeHolder() {
            setOpaque(false);
        }

        void setAlpha(float a) {
            alpha = Math.max(0f, Math.min(1f, a));
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            if (alpha >= 0.99f) {
                super.paint(g);
                return;
            }
            if (alpha <= 0.01f) {
                return;
            }
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
            super.paint(g2);
            g2.dispose();
        }
    }

    private static class FieldBox extends JPanel {
        private boolean focused;

        FieldBox() {
            setOpaque(false);
            setBorder(new EmptyBorder(3, 3, 3, 3));
        }

        void setFocused(boolean f) {
            focused = f;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 4;
            int h = getHeight() - 4;
            Color a = accentNow;
            if (focused) {
                for (int i = 4; i >= 1; i--) {
                    g2.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), 28));
                    g2.setStroke(new BasicStroke(i * 2));
                    g2.drawRoundRect(2, 2, w, h, 16, 16);
                }
            }
            g2.setColor(new Color(6, 11, 26, 235));
            g2.fillRoundRect(2, 2, w, h, 16, 16);
            g2.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), focused ? 255 : 90));
            g2.setStroke(new BasicStroke(1.4f));
            g2.drawRoundRect(2, 2, w, h, 16, 16);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** Translucent glass card whose glowing border follows the lamp colour. */
    private static class GlassCard extends JPanel {
        GlassCard() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth() - 2;
            int h = getHeight() - 2;
            Color a = accentNow;
            for (int i = 8; i >= 1; i--) {
                g2.setColor(new Color(a.getRed(), a.getGreen(), a.getBlue(), 14));
                g2.setStroke(new BasicStroke(i * 3));
                g2.drawRoundRect(1, 1, w, h, 30, 30);
            }
            g2.setColor(new Color(8, 14, 32, 215));
            g2.fillRoundRect(1, 1, w, h, 30, 30);
            g2.setPaint(new GradientPaint(0, 0, a, getWidth(), getHeight(),
                    new Color(a.getRed(), a.getGreen(), a.getBlue(), 70)));
            g2.setStroke(new BasicStroke(1.8f));
            g2.drawRoundRect(1, 1, w, h, 30, 30);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // temporary launcher for testing this window alone
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new LoginWindow(new AccountStore(), u -> System.out.println("Logged in: " + u))
                        .setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}