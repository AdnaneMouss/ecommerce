package com.example.demo.repository;

import com.example.demo.modele.Reclamation;
import com.example.demo.modele.produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
