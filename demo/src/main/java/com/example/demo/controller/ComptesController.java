package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.service.ComptesService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comptes")
public class ComptesController {
    @Autowired
    private ComptesService daoComptes;

    public ComptesController(ComptesService daoComptes) {
        this.daoComptes = daoComptes;
    }

    @GetMapping
    public  List<comptes> getAllAccs() {return daoComptes.getAllAccs();
    }



    @GetMapping("/{id}")
    public comptes getComptesById(@PathVariable int id) {
        Optional<comptes> comptes = daoComptes.getAccById((long)id);
        return comptes.orElse(null);
    }



    @PutMapping("/{id}")
    public boolean updateComptes(@PathVariable int id, @RequestBody comptes updatedComptes) {
        return daoComptes.updateCompte(id, updatedComptes);
    }

    @DeleteMapping("/{id}")
    public boolean deleteComptes(@PathVariable int id) {
        return daoComptes.deleteCompte(id);
    }
    @GetMapping("/profile")
    public String getProfilePage(Model model, String username) {

        comptes compte = daoComptes.findByUsername("myUsername");

        // Passer les données à la vue
        model.addAttribute("comptes", compte);

        return "compte";
    }
    @GetMapping("/count")
    public String countCompte(Model model) {
        // Récupérer le nombre total de comptes
        int countCompte = daoComptes.countcompte();
        model.addAttribute("compteCount",""+countCompte);
System.out.println(""+countCompte);
        // Renvoyer le nom de la vue à afficher



        int Delivery = daoComptes.countcompteByType ("DeliveryMan");
        model.addAttribute("DeliveryMan",""+Delivery);
        System.out.println("DeliveryMan"+Delivery);
        // Renvoyer le nom de la vue à afficher


        int Supplier = daoComptes.countcompteByType ("Supplier");
        model.addAttribute("Supplier",""+Supplier);
        System.out.println("Supplier"+Supplier);
        // Renvoyer le nom de la vue à afficher

        int Student = daoComptes.countcompteByType ("Student");
        model.addAttribute("Student",""+Student);
        System.out.println("Student"+Student);
        // Renvoyer le nom de la vue à afficher

        int Admin = daoComptes.countcompteByType ("Admin");
        model.addAttribute(" Admin",""+Admin);
        System.out.println("Admin"+Admin);
        // Renvoyer le nom de la vue à afficher



    int Architecture = daoComptes.countcompteByFiliere ("Architecture");
        model.addAttribute("Architecturstudents",""+Architecture);
        System.out.println("Architecturstudents"+Architecture);

        int CS = daoComptes.countcompteByFiliere ("CS");
        model.addAttribute("CSstudents",""+CS);
        System.out.println("CSstudents"+CS);

        int Energy = daoComptes.countcompteByFiliere ("Energy");
        model.addAttribute("Energystudents",""+Energy);
        System.out.println("Energystudents"+Energy);

        int Aerospace = daoComptes.countcompteByFiliere ("Aerospace");
        model.addAttribute("Aerospacestudents",""+Aerospace);
        System.out.println("Aerospacestudents"+Aerospace);

        int Medicine = daoComptes.countcompteByFiliere ("Medecine");
        model.addAttribute("Medicinestudents",""+Medicine);
        System.out.println("Medicinestudents"+Medicine);

        int Automobile = daoComptes.countcompteByFiliere ("Automobile");
        model.addAttribute("Automobilestudents",""+Automobile);
        System.out.println("Automobile"+Automobile);


        List<comptes> comptes = daoComptes.getAllAccs();
        model.addAttribute("all",comptes);

        return "dashboard_accounts";
}
    @PostMapping("/addcompteuser")
    public String addProduct( @RequestParam int phone, @RequestParam String fullname,@RequestParam String emailadress,
                             @RequestParam String photo, @RequestParam String username, @RequestParam String password, @RequestParam String field) {


        // Create a product object and set its properties
        comptes account = new comptes();
account.setType("Student");
account.setFiliere(field);
account.setEmail(emailadress);
account.setUsername(username);
account.setNom(fullname);
account.setPhone(phone);
account.setPhoto(photo);

        // Save the product to the database
        daoComptes.createCompte(account);

        // Redirect to the desired page
        return "redirect:/comptes/count";
    }

    @PostMapping("/addcompteforothers")
    public String addProductall( @RequestParam int phone, @RequestParam String fullname,@RequestParam String emailadress,
                               @RequestParam String username, @RequestParam String password,@RequestParam String type, @RequestParam String photo) {



        // Create a product object and set its properties
        comptes account = new comptes();
        account.setType(type);
        account.setPassword(password);
        account.setEmail(emailadress);
        account.setUsername(username);
        account.setNom(fullname);
        account.setPhone(phone);
        account.setPhoto(photo);

        // Save the product to the database
        daoComptes.createCompte(account);

        // Redirect to the desired page
        return "redirect:/comptes/count";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {

        boolean isDeleted = daoComptes.deleteCompte(id);
        if (isDeleted) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Failed to delete account.");
        }

        return "redirect:/comptes/count";
    }
}
