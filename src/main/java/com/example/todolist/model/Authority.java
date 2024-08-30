package com.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Authority class represents the authority or role assigned to a user in the application.
 * It maps to the "authorities" table in the database.
 */
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    private String username;
    private String authority;

    /**
     * Default constructor for JPA.
     */
    public Authority() {
    }

    /**
     * Constructor to create an Authority with a specific username and role.
     *
     * @param username  the username of the user
     * @param authority the role or authority granted to the user
     */
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    /**
     * Gets the username associated with this authority.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username associated with this authority.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the authority or role associated with this user.
     *
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the authority or role associated with this user.
     *
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
