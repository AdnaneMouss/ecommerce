package com.example.demo.service;
import com.example.demo.ProduitRepository;
import com.example.demo.modele.produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<produit> getProduitById(int id) {
        return produitRepository.findById((long) id);
    }

    public produit createProduit(produit produit) {
        return produitRepository.save(produit);
    }

    public produit updateProduit(int id, produit updatedProduit) {
        // Check if the produit exists
        if (produitRepository.existsById((long) id)) {
            return null; // Or throw an exception
        }
        updatedProduit.setId(id); // Ensure the ID matches the path variable
        return produitRepository.save(updatedProduit);
    }

    public boolean deleteProduit(int id) {
        boolean res = false;
        try {
            if(produitRepository.existsById((long) id)) {
                produitRepository.deleteById((long) id);
                res=true;
            }
            else{
                res=false;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
            return false; // Return false if deletion fails
        }
        return res;
    }
}
