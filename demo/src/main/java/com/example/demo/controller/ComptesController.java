package com.example.demo.controller;
import com.example.demo.modele.*;
import com.example.demo.service.DaoComptes;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/comptes")
public class ComptesController {
    @Autowired
    private DaoComptes daoComptes;
    public ComptesController(DaoComptes daoComptes) {
        this.daoComptes = daoComptes;
    }
    @GetMapping
    public  List<Comptes> getAllAccs() {
        return daoComptes.getAllAccs();
    }
    @GetMapping("/{id}")
    public Comptes getComptesById(@PathVariable int id) {
        Optional<Comptes> comptes = daoComptes.getAccById((long)id);
        return comptes.orElse(null);
    }
    @PostMapping("/addComptes")
    public boolean addComptes(@RequestBody Comptes comptes) {
        return daoComptes.createCompte(comptes);
    }
    @PutMapping("/{id}")
    public boolean updateComptes(@PathVariable int id, @RequestBody Comptes updatedComptes) {
        return daoComptes.updateCompte(id, updatedComptes);
    }
    @DeleteMapping("/{id}")
    public boolean deleteComptes(@PathVariable int id) {
        return daoComptes.deleteCompte(id);
    }
}
