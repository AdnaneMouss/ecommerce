package com.example.demo.repository;


import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<comptes, Long> {
    comptes findByUsername(String username);
    Optional<comptes> findByUsernameAndPassword(String username, String password);
}
