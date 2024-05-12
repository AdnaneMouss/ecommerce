package com.example.demo.repository;

import com.example.demo.modele.Reclamation;
import com.example.demo.modele.categorie;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    Reclamation findByUsername(String username);
    int countByType(String type);
    int countByFiliere(String fill);
    Optional<Reclamation> getReclamationById(long id);
}
