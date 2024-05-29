package com.example.demo.service;

import com.example.demo.modele.Panier;
import com.example.demo.modele.produit;
import com.example.demo.repository.PanierRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public boolean deletePanier(int id) {
        boolean res = false;
        try {
            if(panierRepository.existsById((long) id)) {
                panierRepository.deleteById((long) id);
                res=true;
            }
            else{
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
            return false; // Return false if deletion fails
        }
        return res;
    }
}
