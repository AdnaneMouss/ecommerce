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
    private ReclamationRepository ReclamationSer;

    public List<Reclamation> getAllReclamations() {
        return ReclamationSer.findAll();
    }

    public Reclamation getReclamationById(int id) {
        Optional<Reclamation> reclamation = ReclamationSer.findById((long) id);
        return reclamation.orElse(null); // Return null if reclamation is not found
    }

    public Reclamation createReclamation(Reclamation reclamation) {
        return ReclamationSer.save(reclamation);
    }

    public void deleteReclamation(int id) {
        ReclamationSer.deleteById((long) id);
    }
}
