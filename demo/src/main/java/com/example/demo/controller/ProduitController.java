package com.example.demo.controller;

import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public produit getProduitById(@PathVariable Long id) {
        Optional<produit> produit = produitService.getProduitById(id);
        return produit.orElse(null); // Return null if produit is not found
    }

    @PostMapping
    public produit createProduit(@RequestBody produit produit) {
        return produitService.createProduit(produit);
    }

    @PutMapping("/{id}")
    public produit updateProduit(@PathVariable Long id, @RequestBody produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
