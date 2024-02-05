package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Login Controller
 *
 * <p>This controller handles requests for the login page of the application.

 */
@Controller
public class LoginController {
     /**
     * Gets the login page.
     *
     * @return The login page view.
     */
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    
}
