package com.example.demo.service;

import com.example.demo.modele.comptes;
import com.example.demo.repository.ComptesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
   @Autowired
   private final ComptesRepository comptesRepository;

    public UsersService(ComptesRepository comptesRepository) {
        this.comptesRepository = comptesRepository;
    }
    public comptes authenticate(String username,String password){
        return comptesRepository.findByUsernameAndPassword(username,password).orElse(null);
    }
}
