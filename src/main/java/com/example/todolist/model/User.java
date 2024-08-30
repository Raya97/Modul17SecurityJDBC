package com.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The User class represents a user entity in the application.
 * It maps to the "users" table in the database and stores user information
 * such as username, password, and the status of the account.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;

    /**
     * Default constructor for JPA.
     */
    public User() {}

    /**
     * Constructor to create a User with a specific username and password.
     * The user is enabled by default.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true; // за замовчуванням встановлюємо користувача як активного
    }

    /**
     * Gets the unique ID of the user.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique ID of the user.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if the user account is enabled.
     *
     * @return true if the account is enabled, false otherwise
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the status of the user account.
     *
     * @param enabled true to enable the account, false to disable it
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
