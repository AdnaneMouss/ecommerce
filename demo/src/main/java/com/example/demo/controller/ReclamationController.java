package com.example.demo.controller;

import com.example.demo.modele.Reclamation;
import com.example.demo.modele.comptes;
import com.example.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    private ReclamationService ReclamationSer;

    public ReclamationController(ReclamationService reclamationService) {
        this.ReclamationSer = reclamationService;
    }

    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return ReclamationSer.getAllReclamations();
    }

    @GetMapping("/{id}")
    public Reclamation getReclamationById(@PathVariable int id) {
        Reclamation Reclamation = ReclamationSer.getReclamationById(id);
        return Reclamation;
    }

    @PostMapping("/addReclamation")
    public boolean createReclamation(@RequestBody Reclamation reclamation) {
        return ReclamationSer.createReclamation(reclamation);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReclamation(@PathVariable int id) {
        ReclamationSer.deleteReclamation(id);
        return false;
    }

    @GetMapping("/count")
    public String countcomplaint(Model model) {
        // Récupérer le nombre total de comptes
        int countcomplaint = ReclamationSer.countcomplaint();
        model.addAttribute("countcomplaint", "" + countcomplaint);
        System.out.println("" + countcomplaint);
        // Renvoyer le nom de la vue à afficher



        int Delivery = ReclamationSer.countcomplaintByType ("DeliveryMan");
        model.addAttribute("DeliveryMan",""+Delivery);
        System.out.println("DeliveryMan"+Delivery);
        // Renvoyer le nom de la vue à afficher


        int Supplier = ReclamationSer.countcomplaintByType ("Supplier");
        model.addAttribute("Supplier",""+Supplier);
        System.out.println("Supplier"+Supplier);
        // Renvoyer le nom de la vue à afficher

        int Student = ReclamationSer.countcomplaintByType ("Student");
        model.addAttribute("Student",""+Student);
        System.out.println("Student"+Student);
        // Renvoyer le nom de la vue à afficher

        int Admin = ReclamationSer.countcomplaintByType ("Admin");
        model.addAttribute(" Admin",""+Admin);
        System.out.println("Admin"+Admin);
        // Renvoyer le nom de la vue à afficher



        int Architecture = ReclamationSer.countcomplaintByFiliere ("Architecture");
        model.addAttribute("Architecturstudents",""+Architecture);
        System.out.println("Architecturstudents"+Architecture);

        int CS = ReclamationSer.countcomplaintByFiliere ("CS");
        model.addAttribute("CSstudents",""+CS);
        System.out.println("CSstudents"+CS);

        int Energy = ReclamationSer.countcomplaintByFiliere ("Energy");
        model.addAttribute("Energystudents",""+Energy);
        System.out.println("Energystudents"+Energy);

        int Aerospace = ReclamationSer.countcomplaintByFiliere ("Aerospace");
        model.addAttribute("Aerospacestudents",""+Aerospace);
        System.out.println("Aerospacestudents"+Aerospace);

        int Medicine = ReclamationSer.countcomplaintByFiliere ("Medecine");
        model.addAttribute("Medicinestudents",""+Medicine);
        System.out.println("Medicinestudents"+Medicine);

        int Automobile = ReclamationSer.countcomplaintByFiliere ("Automobile");
        model.addAttribute("Automobilestudents",""+Automobile);
        System.out.println("Automobile"+Automobile);


        return "dashboard_complaints";
    }
}
