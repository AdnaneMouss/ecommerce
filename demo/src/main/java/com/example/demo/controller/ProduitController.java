package com.example.demo.controller;

import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public produit getProduitById(@PathVariable int id) {
        Optional<produit> produit = produitService.getProduitById(id);
        return produit.orElse(null);
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody produit product) {
        produitService.createProduit(product);
        // Optionally, you can add attributes to the model to display a success message or redirect to another page
        return "redirect:/signup.html"; // Redirect to a page displaying the list of products
    }

    @PutMapping("/{id}")
    public produit updateProduit(@PathVariable int id, @RequestBody produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduit(@PathVariable int id) {
        return produitService.deleteProduit(id);
    }
}
