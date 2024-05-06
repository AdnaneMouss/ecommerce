package com.example.demo.service;
import com.example.demo.modele.comptes;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public comptes login(String username, String password) {
        comptes user = repo.findByUsernameAndPassword(username, password);
        return user;
    }


}