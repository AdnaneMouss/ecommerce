package com.example.demo;

import com.example.demo.modele.produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<produit, Long> {
    // You can add custom query methods here if needed
}
