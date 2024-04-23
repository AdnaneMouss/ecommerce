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
        Optional<produit> produit = produitService.getProduitById((long)id);
        return produit.orElse(null);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody produit product) {
        return produitService.createProduit(product);
    }

    @PutMapping("/{id}")
    public boolean updateProduit(@PathVariable int id, @RequestBody produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduit(@PathVariable int id) {
        return produitService.deleteProduit(id);
    }

    @GetMapping("/products/count")
    public String countProducts(Model model) {
        int productCount = produitService.countProduits();
        model.addAttribute("productCount", productCount);
        return "analytics";
    }
}
