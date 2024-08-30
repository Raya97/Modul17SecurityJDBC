package com.example.todolist.controller;

import com.example.todolist.model.User;
import com.example.todolist.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The RegistrationController handles the registration of new users.
 * It provides endpoints for displaying the registration form and processing the form submissions.
 */
@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;

    /**
     * Constructor for injecting the UserService dependency.
     *
     * @param userService the service used for user operations
     */
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles GET requests to the "/register" endpoint.
     * Displays the registration form to the user.
     *
     * @param model the model to hold form data
     * @return the name of the Thymeleaf template for the registration page
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Handles POST requests to the "/register" endpoint.
     * Processes the registration form submission, saves the new user, and redirects to the login page.
     *
     * @param user   the user object populated from the form data
     * @param result the binding result to handle validation errors
     * @param model  the model to hold any error messages
     * @return a redirect to the login page upon successful registration, or the registration form if there are errors
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register"; // Return the form with validation errors
        }
        try {
            logger.info("Attempting to register user: " + user.getUsername());
            user.setEnabled(true);
            userService.saveUser(user);
            logger.info("User registered successfully: " + user.getUsername());
            return "redirect:/login";
        } catch (Exception e) {
            logger.error("Error occurred during registration: ", e);
            model.addAttribute("registrationError", "An error occurred during registration.");
            return "register";
        }
    }
}
