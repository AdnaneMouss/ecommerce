package com.example.demo.service;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categRepository;

    public List<categorie> getAllCategories() {
        return categRepository.findAll();
    }

    public Optional<categorie> getCategorieById(int id) {
        return categRepository.findById((long) id);
    }

    public boolean createCategorie(categorie categorie) {
        boolean res = false;
        try{
            categRepository.save(categorie);
             res=true;
        }
        catch(Exception e){
            System.out.println(e);
            return res;
        }
        return res;
    }

    public boolean deleteCategorie(int id) {
        boolean res = false;
        try {
            if(categRepository.existsById((long) id)) {
                categRepository.deleteById((long) id);
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
