package com.example.todolist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomErrorController handles all application errors and directs users to a
 * custom error page. This class implements the ErrorController interface
 * provided by Spring Boot to override the default error handling mechanism.
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * This method is mapped to the "/error" URL and handles errors by returning
     * the name of the error view. The view name corresponds to an HTML file
     * located in the 'templates' folder.
     *
     * @return the name of the error view, typically "error".
     */
    @RequestMapping("/error")
    public String handleError() {
        // Add error handling logic here
        return "error";  // this corresponds to an error.html file in the templates folder
    }


}
