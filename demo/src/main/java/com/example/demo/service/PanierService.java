package com.example.demo.service;

import com.example.demo.modele.Panier;
import com.example.demo.modele.commande;
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
        boolean res;
        if(panierRepository.existsById((long) id)) {
            panierRepository.deleteById((long) id);
            res=true;
        }
        else{
            res=false;
        }
        return res;
    }

    public boolean createPanier(Panier panier) {
        boolean res=false;
        try{
            panierRepository.save(panier);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public Optional<Panier> findPanierByCompteId(int id) {
        return panierRepository.findByCompteId(id);
    }
}
