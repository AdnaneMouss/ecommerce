package com.example.demo.service;
import com.example.demo.modele.Comptes;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Loginservice {
    @Autowired
    private LoginRepository repo;
    public Comptes login(String username, String password) {
        Comptes user = repo.findByUsernameAndPassword(username, password);
        return user;
    }
}
