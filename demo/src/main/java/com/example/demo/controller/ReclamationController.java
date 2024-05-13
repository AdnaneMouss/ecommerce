package com.example.demo.controller;

import com.example.demo.modele.Reclamation;
import com.example.demo.modele.comptes;
import com.example.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    private static ReclamationService ReclamationSer;
    public ReclamationController(ReclamationService reclamationService) {
        this.ReclamationSer = reclamationService;
    }

    @GetMapping
    public  List<Reclamation> getAllReclamations() {
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
}
