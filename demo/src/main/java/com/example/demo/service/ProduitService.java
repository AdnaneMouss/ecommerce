package com.example.demo.service;
import com.example.demo.repository.ProduitRepository;
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

    public boolean createProduit(produit produit) {
        boolean res = false;
        try{
            produitRepository.save(produit);
             res=true;
        }
        catch(Exception e){
            System.out.println(e);
            return res;
        }
        return res;
    }

    public boolean updateProduit(int id, produit updatedProduit) {
        boolean res = false;
        try{
            updatedProduit.setId(id);
            produitRepository.save(updatedProduit);
            res=true;
        }
        catch(Exception e){
            return res;
        }
        return res;
    }


    public boolean deleteProduit(int id) {
        boolean res = false;
        try {
            if(produitRepository.existsById((long) id)) {
                produitRepository.deleteById((long) id);
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
