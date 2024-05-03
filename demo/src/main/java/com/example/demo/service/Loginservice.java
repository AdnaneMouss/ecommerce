package com.example.demo.service;
import com.example.demo.modele.Comptes;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Loginservice {
    @Autowired
    private LoginRepository repo;

    public boolean authenticate(String username, String password) {
        boolean res = false;
        if (repo.existsByUsernameAndPassword(username, password)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }
}
