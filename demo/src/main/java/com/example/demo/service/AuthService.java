package com.example.demo.service;

public interface AuthService {
    String login(String username, String password);

    void logout();
}
