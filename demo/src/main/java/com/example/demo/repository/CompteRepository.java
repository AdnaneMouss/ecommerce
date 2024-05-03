package com.example.demo.repository;

import com.example.demo.modele.Comptes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Comptes, Long> {
    Comptes findByUsername(String username);
}
