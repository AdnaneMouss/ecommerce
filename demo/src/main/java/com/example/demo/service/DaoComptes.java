package com.example.demo.service;

import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DaoComptes{
    public DaoComptes(){}

public DaoComptes(CompteRepository compteRepository){
        this.compteRepository=compteRepository;
}
@Autowired
    private static CompteRepository compteRepository;

    public static List<comptes> getAllAccs() {
        return compteRepository.findAll();
    }

    public static Optional<comptes> getAccById(Long id) {
        return compteRepository.findById(id);
    }

    public static boolean createCompte(comptes compte) {
        boolean res=false;
        try{
            compteRepository.save(compte);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public static boolean updateCompte(int id, comptes updatedCompte) {
        boolean res=false;
        try{
            compteRepository.save(updatedCompte);
            updatedCompte.setId(id);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public static boolean deleteCompte(int id) {
        boolean res;
        if(compteRepository.existsById((long) id)) {
            res=false;
        }
        else{
            compteRepository.deleteById((long) id);
            res=true;
        }
        return res;
    }
}
