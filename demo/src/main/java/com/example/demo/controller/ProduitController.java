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
@RequestMapping("/products")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService catService;

    @GetMapping("/catalogue")
    public String getAllProduits(Model model) {
        List<produit> produits = produitService.getAllProduits();
        model.addAttribute("all",produits);
        return "shop";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String label, @RequestParam int price, @RequestParam String color,
                             @RequestParam String photo, @RequestParam String size, @RequestParam int categoryId) {
        // Fetch the category object by ID
        Optional<categorie> categoryOptional = catService.getCategoryById(categoryId);

            categorie category = categoryOptional.get();

            // Create a product object and set its properties
            produit product = new produit();
            product.setLabel(label);
            product.setPrice(price);
            product.setColor(color);
            product.setPhoto(photo);
            product.setSize(size);

            // Set the category for the product
            product.setCategorie(category);

            // Save the product to the database
            produitService.createProduit(product);

            // Redirect to the desired page
            return "redirect:/products/count";
    }

    @PutMapping("/{id}")
    public boolean updateProduit(@PathVariable int id, @RequestBody produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {

            boolean isDeleted = produitService.deleteProduit(id);
            if (isDeleted) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete product.");
            }

        return "redirect:/products/count";
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
        //getall
        List<produit> produits = produitService.getAllProduits();
        model.addAttribute("all",produits);
        List<categorie> c = catService.getAllCategories();
        model.addAttribute("allc",c);
        return "products";
    }
}
