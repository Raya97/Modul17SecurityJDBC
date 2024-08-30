package com.example.todolist.controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is a controller advice class that handles exceptions
 * thrown by any controller in the application. This class ensures that all
 * exceptions are caught and properly handled, providing a consistent error
 * response across the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method handles all exceptions of type Exception or its subclasses.
     * It adds the exception message to the model and returns the "error" view
     * to display the error page.
     *
     * @param ex the exception that was thrown
     * @param model the model to which the error message is added
     * @return the name of the error view, typically "error"
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // your custom error page template
    }
}
