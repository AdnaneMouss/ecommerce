package com.example.demo.repository;


import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<commande, Long> {
int countCommandesByCompte(comptes compte);
}
