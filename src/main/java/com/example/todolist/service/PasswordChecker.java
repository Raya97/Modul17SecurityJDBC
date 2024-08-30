package com.example.todolist.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * PasswordChecker is a utility class that checks if a raw password matches an encoded password.
 * It uses the BCryptPasswordEncoder to verify the password.
 */
public class PasswordChecker {
    /**
     * The main method serves as the entry point for the PasswordChecker utility.
     * It encodes a raw password and compares it with an already encoded password to see if they match.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // The raw password you want to check.
        String rawPassword = "jdbcDefault";
        // The encoded password to compare against.
        String encodedPassword = "$2a$10$EheWyqarHycc57Qeyb4lreEYmAJmCHWcxUdeOsvneweTbK0LAWpYi";

        // Checks if the raw password matches the encoded password
        boolean isMatch = encoder.matches(rawPassword, encodedPassword);
        // Prints the result of the password match check.
        System.out.println("Пароль підходить: " + isMatch);
    }
}
