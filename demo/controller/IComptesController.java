package com.example.demo.controller;

import com.example.demo.model.comptes;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IComptesController {

    List<comptes> getAllComptes();

    ResponseEntity<Object> getCompteById(Long id);

    ResponseEntity<comptes> addComptes(comptes comptes);

    ResponseEntity<comptes> updateComptes(Long id, comptes comptes);

    void deleteCompte(Long id);

}
