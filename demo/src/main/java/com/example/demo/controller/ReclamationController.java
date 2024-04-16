package com.example.demo.controller;

import com.example.demo.modele.Reclamation;
import com.example.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    private ReclamationService ReclamationService;

    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return ReclamationService.getAllReclamations();
    }

    @GetMapping("/{id}")
    public Reclamation getReclamationById(@PathVariable Long id) {
        return ReclamationService.getReclamationById(id);
    }

    @PostMapping
    public Reclamation createReclamation(@RequestBody Reclamation reclamation) {
        return ReclamationService.createReclamation(reclamation);
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        ReclamationService.deleteReclamation(id);
    }
}
