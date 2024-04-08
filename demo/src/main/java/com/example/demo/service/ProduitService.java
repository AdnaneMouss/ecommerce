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

    public Optional<produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public produit createProduit(produit produit) {
        return produitRepository.save(produit);
    }

    public produit updateProduit(Long id, produit updatedProduit) {
        // Check if the produit exists
        if (!produitRepository.existsById(id)) {
            return null; // Or throw an exception
        }
        updatedProduit.setId(id); // Ensure the ID matches the path variable
        return produitRepository.save(updatedProduit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
