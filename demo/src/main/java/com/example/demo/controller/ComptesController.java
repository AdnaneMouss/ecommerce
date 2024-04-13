package com.example.demo.controller;

import com.example.demo.modele.comptes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comptes")
public class ComptesController implements IComptesController {

    private List<comptes> comptesList = new ArrayList<>();

    @Override
    @GetMapping
    public List<comptes> getAllComptes() {
        return comptesList;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompteById(@PathVariable Long id) {
        comptes compte = findCompteById(id);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<comptes> addComptes(@RequestBody comptes compte) {
        comptesList.add(compte);
        return ResponseEntity.status(HttpStatus.CREATED).body(compte);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<comptes> updateComptes(@PathVariable Long id, @RequestBody comptes updatedCompte) {
        comptes existingCompte = findCompteById(id);
        if (existingCompte != null) {
            existingCompte.setUsername(updatedCompte.getUsername());
            // Update other fields as needed
            return ResponseEntity.ok(existingCompte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        comptes compte = findCompteById(id);
        if (compte != null) {
            comptesList.remove(compte);
        }
    }

    private comptes findCompteById(Long id) {
        for (comptes compte : comptesList) {
            if (compte.getId().equals(id)) {
                return compte;
            }
        }
        return null;
    }
}
