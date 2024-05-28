package com.example.demo.controller;

import com.example.demo.modele.Panier;
import com.example.demo.modele.categorie;
import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ComptesService;
import com.example.demo.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    public PanierController(PanierService panierservice) {
        this.panierservice = panierservice;
    }
    @GetMapping("/getpanier")
    public String getPanierById(@RequestParam String username) {

        return "redirect:/panier/panier/" + username;
    }

    @GetMapping("/panier/{username}")
    public String getPanierByUsername(@PathVariable ("username") String username, Model model) {
        Optional<comptes> categoryOptional = comptesService.getAccById(2L);
        comptes c = categoryOptional.get();
        List<commande> avoir = comm.findAllByPanierCompteEquals(c);
        model.addAttribute("panier", avoir);
        return "Panier";
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduit(@PathVariable int id) {
        return panierservice.deleteprod(id);
    }
    @GetMapping("/panier2")
    public String getPanierPage(Model model, String username) {
        Panier panier = new Panier();
        model.addAttribute("comptes", panier);
        return "panier";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        boolean isDeleted = panierservice.deleteprod(id);
        if (isDeleted) {
            System.out.println("Product deleted successfully from your basket.");
        } else {
            System.out.println("Failed to delete product from your basket.");
        }
        return "redirect:/comptes/count";
    }
}
