
package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AccountStore {

    private static final int ITERATIONS = 120000;
    private static final int KEY_LENGTH = 256;

    private final Path filePath =
        Paths.get("data", "accounts.txt");

    private final SecureRandom random = new SecureRandom();

    public AccountStore() throws IOException {
        Files.createDirectories(filePath.getParent());

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    public boolean register(
        String username,
        String email,
        char[] password
    ) throws IOException, GeneralSecurityException {

        username = username.trim();
        email = email.trim();

        if (username.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException(
                "Username and email are required."
            );
        }

        if (password.length < 8) {
            throw new IllegalArgumentException(
                "Password must have at least 8 characters."
            );
        }

        if (accountExists(username, email)) {
            return false;
        }

        byte[] salt = new byte[16];
        random.nextBytes(salt);

        byte[] hash = hashPassword(password, salt, ITERATIONS);

        String record =
            encode(username) + ":" +
            encode(email) + ":" +
            ITERATIONS + ":" +
            encodeBytes(salt) + ":" +
            encodeBytes(hash);

        Files.write(
            filePath,
            (record + System.lineSeparator()).getBytes(
                StandardCharsets.UTF_8
            ),
            java.nio.file.StandardOpenOption.APPEND
        );

        return true;
    }

    public boolean authenticate(
        String usernameOrEmail,
        char[] password
    ) throws IOException, GeneralSecurityException {

        String login = usernameOrEmail.trim();

        List<String> accounts =
            Files.readAllLines(filePath, StandardCharsets.UTF_8);

        for (String account : accounts) {

            String[] parts = account.split(":", -1);

            if (parts.length != 5) {
                continue;
            }

            String username = decode(parts[0]);
            String email = decode(parts[1]);

            if (!login.equalsIgnoreCase(username) &&
                !login.equalsIgnoreCase(email)) {
                continue;
            }

            int iterations = Integer.parseInt(parts[2]);
            byte[] salt = decodeBytes(parts[3]);
            byte[] savedHash = decodeBytes(parts[4]);

            byte[] enteredHash =
                hashPassword(password, salt, iterations);

            return MessageDigest.isEqual(
                savedHash,
                enteredHash
            );
        }

        return false;
    }

    private boolean accountExists(
        String username,
        String email
    ) throws IOException {

        List<String> accounts =
            Files.readAllLines(filePath, StandardCharsets.UTF_8);

        for (String account : accounts) {

            String[] parts = account.split(":", -1);

            if (parts.length != 5) {
                continue;
            }

            String savedUsername = decode(parts[0]);
            String savedEmail = decode(parts[1]);

            if (savedUsername.equalsIgnoreCase(username) ||
                savedEmail.equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    private byte[] hashPassword(
        char[] password,
        byte[] salt,
        int iterations
    ) throws GeneralSecurityException {

        PBEKeySpec spec =
            new PBEKeySpec(password, salt, iterations, KEY_LENGTH);

        try {
            SecretKeyFactory factory =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            return factory.generateSecret(spec).getEncoded();

        } finally {
            spec.clearPassword();
        }
    }

    private String encode(String value) {
        return Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    private String decode(String value) {
        return new String(
            Base64.getUrlDecoder().decode(value),
            StandardCharsets.UTF_8
        );
    }

    private String encodeBytes(byte[] value) {
        return Base64.getEncoder().encodeToString(value);
    }

    private byte[] decodeBytes(String value) {
        return Base64.getDecoder().decode(value);
    }
}
