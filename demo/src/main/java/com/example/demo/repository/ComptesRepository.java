package com.example.demo.repository;


import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComptesRepository extends JpaRepository<comptes, Integer> {
    Optional<comptes> findByUsernameAndPassword(String username, String password);
}
