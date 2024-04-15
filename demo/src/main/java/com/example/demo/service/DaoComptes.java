package com.example.demo.service;

import com.example.demo.modele.comptes;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

public class DaoComptes implements IDaocomptes{

    private List<comptes> comptesList = new ArrayList<>();

    @Override
    public List<comptes> getAllComptes() {
        return comptesList;
    }


    @Override
    public comptes getCompteById(Long id) {
        for (comptes compte : comptesList) {
            if (compte.getId().equals(id)) {
                return compte;
            }
        }
        return null;
    }

    @Override
    public void addCompte(comptes compte) {
        comptesList.add(compte);
    }

    @Override
    public void updateCompte(comptes updatedCompte) {
        for (comptes compte : comptesList) {
            if (compte.getId().equals(updatedCompte.getId())) {
                compte.setUsername(updatedCompte.getUsername());
                // Update other fields as needed
                break;
            }
        }
    }

    @Override
    public void deleteCompte(Long id) {
        comptes compteToRemove = null;
        for (comptes compte : comptesList) {
            if (compte.getId().equals(id)) {
                compteToRemove = compte;
                break;
            }
        }
        if (compteToRemove != null) {
            comptesList.remove(compteToRemove);
        }
    }

}
