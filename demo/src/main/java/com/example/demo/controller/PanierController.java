package com.example.demo.controller;

import com.example.demo.modele.*;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ComptesService;
import com.example.demo.service.PanierService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/panier")
public class PanierController {
    @Autowired
    private PanierService panierservice;
    @Autowired
    private CommandeService comm;
    @Autowired
    private ComptesService comptesService;
    @Autowired
    private ProduitService produitService;

    public PanierController(PanierService panierservice) {
        this.panierservice = panierservice;
    }

    //PANIER
    @GetMapping("/getpanier")
    public String getPanierById(@RequestParam int id, @RequestParam String username) {
        return "redirect:/panier/panier/" + id + "/" + username;
    }

    @GetMapping("/panier/{id}/{username}")
    public String getPanierByUsername(@PathVariable("id") int id, @PathVariable("username") String username, Model model) {
        Optional<comptes> categoryOptional = comptesService.getAccById((long) id);
        comptes c = categoryOptional.orElseThrow(() -> new RuntimeException("Compte not found"));
        List<commande> avoir = comm.findAllByPanierCompteEquals(c);
        model.addAttribute("panier", avoir);
        return "Panier";
    }

    //PENDINGDELIVERIES
    @GetMapping("/getpending")
    public String getPendingById(@RequestParam int id, @RequestParam String username) {
        return "redirect:/panier/pending/" + id + "/" + username;
    }

    @GetMapping("/pending/{id}/{username}")
    public String getPendingByUsername(@PathVariable("id") int id, @PathVariable("username") String username, Model model) {
        Optional<comptes> categoryOptional = comptesService.getAccById((long) id);
        comptes c = categoryOptional.orElseThrow(() -> new RuntimeException("Compte not found"));
        List<commande> avoir = comm.findAllByPanierCompteEquals(c);
        model.addAttribute("pending", avoir);
        return "Pending";
    }

    @GetMapping("/panier2")
    public String getPanierPage(Model model, String username) {
        Panier panier = new Panier();
        model.addAttribute("comptes", panier);
        return "panier";
    }

    // Ajout de la méthode de suppression de produit du panier
    @PostMapping("/deletePan")
    public String delete(@RequestParam int idPanier) {
        boolean isDeleted = panierservice.deletePanier(idPanier);
        if (isDeleted) {
            System.out.println("Product deleted successfully from basket.");
        } else {
            System.out.println("Failed to delete prod.");
        }
        return "redirect:/categories/categories";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam int quantity, @RequestParam int productId) {

        Optional<produit> produitOptional = produitService.getProduitById((long)productId);
        produit p = produitOptional.get();

        commande comm = new commande();
        comm.setQuantity(quantity);
        comm.setP(p);
        Panier pan = new Panier();
        comm.setPanier(pan);
        return "redirect:/panier/products";
    }

}
