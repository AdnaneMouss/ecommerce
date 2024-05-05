package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import com.example.demo.service.CategorieService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService catService;
    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<categorie> getAllCategories() {
        return catService.getAllCategories();
    }

    @GetMapping("/{id}")
    public categorie getCategoryById(@PathVariable int id) {
        Optional<categorie> c = catService.getCategoryById(id);
        return c.orElse(null);
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String catname, Model model) {
        // Create a new category object
        categorie categorie = new categorie();
        categorie.setCatname(catname);

        // Check if the category already exists
        boolean isCategoryCreated = catService.createCategorie(categorie);

        if (isCategoryCreated) {
            // Category created successfully, redirect to the desired page
            return "redirect:/products/products";
        } else {
            System.out.println("exists already");
            // Category already exists, add error message to the model
            model.addAttribute("errorMessage", "Category already exists!");
        }
        return "redirect:/products/products";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idC) {
        boolean isDeleted = catService.deleteCategorie(idC);
        if (isDeleted) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Failed to delete product.");
        }

        return "redirect:/products/products";
    }

}
