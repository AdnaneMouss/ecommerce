package com.example.demo.repository;

import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteRepository extends JpaRepository<comptes, Long> {
}
