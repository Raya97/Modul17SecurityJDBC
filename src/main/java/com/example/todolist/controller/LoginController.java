package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginController handles the routing for the login page.
 * This controller is responsible for displaying the login page to the user.
 */
@Controller
public class LoginController {

    /**
     * Handles GET requests to the "/login" endpoint.
     *
     * @return the name of the Thymeleaf template for the login page, typically "login".
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // The name of the Thymeleaf template for the login page
    }
}
