package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
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

    @GetMapping("/count")
    public String countProducts(Model model) {
        //All products
        int productCount = produitService.countProduits();
        model.addAttribute("productCount", ""+productCount);
        //Archi
        categorie archi = new categorie(1,"Archi");
        int countArchi = produitService.countProduitsByCategorie(archi);
        model.addAttribute("archi", ""+countArchi);
        //Auto
        categorie auto = new categorie(2,"Auto");
        int countAuto = produitService.countProduitsByCategorie(auto);
        model.addAttribute("auto", ""+countAuto);
        //Aero
        categorie aero = new categorie(3,"Aero");
        int countAero = produitService.countProduitsByCategorie(aero);
        model.addAttribute("aero", ""+countAero);
        //CS
        categorie cs = new categorie(4,"CS");
        int countCS = produitService.countProduitsByCategorie(cs);
        model.addAttribute("cs", ""+countCS);
        //Dentaire
        categorie dentistry = new categorie(5,"Dentistry");
        int countDentistry = produitService.countProduitsByCategorie(dentistry);
        model.addAttribute("dentistry", ""+countDentistry);
        //Générale
        categorie medecine = new categorie(6,"Medecine");
        int countMedecine = produitService.countProduitsByCategorie(medecine);
        model.addAttribute("medecine", ""+countMedecine);
        //Energie
        categorie energie = new categorie(7,"Energy");
        int countEnergie = produitService.countProduitsByCategorie(energie);
        model.addAttribute("energie", ""+countEnergie);
        return "products";
    }
}
