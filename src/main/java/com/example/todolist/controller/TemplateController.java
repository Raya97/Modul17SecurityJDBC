package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    // Handle GET requests to the "/test" URL
    @GetMapping("/test")
    public String test() {
        // Return the view name "test" to render the corresponding Thymeleaf template (test.html)
        return "test";
    }
}
