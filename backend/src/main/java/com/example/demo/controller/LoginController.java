package com.example.demo.controller;

import com.example.demo.Dao.AuthRequest;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * Login Controller
 *
 * <p>This controller handles requests for the login page of the application.

 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
     /**
     * Gets the login page.
     *
     * @return The login page view.
     */
//    "/login")
//    public String getLogin() {
//        return "login";
//    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
    
}
