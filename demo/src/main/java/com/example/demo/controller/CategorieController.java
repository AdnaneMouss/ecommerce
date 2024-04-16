package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import com.example.demo.service.CategorieService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categorie")
public class CategorieController {

    @Autowired
    private CategorieService catService;

    @GetMapping
    public List<categorie> getAllCategories() {
        return catService.getAllCategories();
    }

    @GetMapping("/{id}")
    public categorie getCategorieById(@PathVariable int id) {
        Optional<categorie> c = catService.getCategorieById(id);
        return c.orElse(null);
    }

    @PostMapping("/addCategory")
    public boolean addCategorie(@RequestBody categorie c) {
        return catService.createCategorie(c);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategorie(@PathVariable int id) {
        return catService.deleteCategorie(id);
    }
}
