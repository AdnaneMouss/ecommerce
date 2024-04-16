package com.example.demo.controller;

import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.service.DaoComptes;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comptes")
public class ComptesController{

    @Autowired
    private DaoComptes dao;

    @GetMapping
    public List<comptes> getAllAccs() {
        return dao.getAllAccs();
    }

    @GetMapping("/{id}")
    public comptes getAccById(@PathVariable int id) {
        Optional<comptes> c = dao.getAccById((long)id);
        return c.orElse(null);
    }

    @PostMapping("/addProduct")
    public boolean addAcc(@RequestBody comptes c) {
        return dao.createCompte(c);
    }

    @PutMapping("/{id}")
    public boolean updateAcc(@PathVariable int id, @RequestBody comptes updatedCompte) {
        return dao.updateCompte(id, updatedCompte);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAcc(@PathVariable int id) {
        return dao.deleteCompte(id);
    }
}
