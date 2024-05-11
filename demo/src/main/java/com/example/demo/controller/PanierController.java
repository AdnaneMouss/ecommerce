package com.example.demo.controller;
import com.example.demo.modele.Panier;
import com.example.demo.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/paniers")
public class PanierController {
    @Autowired
    private PanierService panierService;
    @PostMapping
    public ResponseEntity<Panier> créerPanier(@RequestBody Panier panier) {
        Panier nouveauPanier = panierService.créerPanier(panier);
        return new ResponseEntity<>(nouveauPanier, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Panier>> obtenirTousLesPaniers() {
        List<Panier> paniers = panierService.obtenirTousLesPaniers();
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Panier> obtenirPanierParId(@PathVariable Long id) {
        Panier panier = panierService.obtenirPanierParId(id);
        return new ResponseEntity<>(panier, HttpStatus.OK);
    }
    /*@PutMapping("/{id}")
    public ResponseEntity<Panier> mettreÀJourPanier(@PathVariable Long id, @RequestBody Panier nouveauPanier) {
        Panier panierMaj = panierService.mettreÀJourPanier(id, nouveauPanier);
        return new ResponseEntity<>(panierMaj, HttpStatus.OK);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerPanier(@PathVariable Long id) {
        panierService.supprimerPanier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

