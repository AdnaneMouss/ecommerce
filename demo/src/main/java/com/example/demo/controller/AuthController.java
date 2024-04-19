package com.example.demo.controller;

import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        if (token != null) {
            return token;
        } else {
            return "Échec de l'authentification";
        }
    }
    static class LoginRequest {
        private String username;
        private String password;
    }
    public AuthService getAuthService() {
        return authService;
    }
}