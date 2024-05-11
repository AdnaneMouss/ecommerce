package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.modele.Panier;
import com.example.demo.repository.PanierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;
    public Panier créerPanier(Panier panier) {
        return panierRepository.save(panier);
    }
    public List<Panier> obtenirTousLesPaniers() {
        return panierRepository.findAll();
    }
    public Panier obtenirPanierParId(Long id) {
        return panierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Panier introuvable avec l'ID : " + id));
    }
    /*public Panier mettreÀJourPanier(Long id, Panier nouveauPanier) {
        Panier panier = obtenirPanierParId(id);
         Mettre à jour les propriétés du panier avec les valeurs du nouveauPanier
         Exemple : panier.setUtilisateur(nouveauPanier.getUtilisateur());
        return panierRepository.save(panier);
    }*/
    public void supprimerPanier(Long id) {
        panierRepository.deleteById(id);
    }
}


