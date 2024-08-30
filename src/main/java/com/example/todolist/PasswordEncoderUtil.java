package com.example.todolist;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * PasswordEncoderUtil is a utility class that provides a method to encode
 * raw passwords using BCrypt encryption. This class is useful for testing
 * or generating hashed passwords that can be stored securely in a database.
 */
public class PasswordEncoderUtil {

    /**
     * Encodes a raw password using BCryptPasswordEncoder.
     *
     * @param rawPassword The raw password that needs to be encrypted.
     * @return The encrypted password as a String.
     */
    public static String encodePassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    /**
     * Main method for testing the password encoding functionality.
     * It encodes a predefined password and prints the hashed result.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String rawPassword = "jdbcDefault";
        String hashedPassword = encodePassword(rawPassword);
        System.out.println("Зашифрований пароль: " + hashedPassword);
    }
}
