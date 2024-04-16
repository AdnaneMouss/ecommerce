package com.example.demo.service;

import com.example.demo.modele.Reclamation;
import com.example.demo.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository ReclamationService;

    public List<Reclamation> getAllReclamations() {
        return ReclamationService.findAll();
    }

    public Reclamation getReclamationById(Long id) {
        Optional<Reclamation> reclamation = ReclamationService.findById(id);
        return reclamation.orElse(null); // Return null if reclamation is not found
    }

    public Reclamation createReclamation(Reclamation reclamation) {
        return ReclamationService.save(reclamation);
    }

    public void deleteReclamation(Long id) {
        ReclamationService.deleteById(id);
    }
}
