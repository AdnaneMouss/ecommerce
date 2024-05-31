package com.example.demo.service;

import com.example.demo.modele.categorie;
import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ComptesService comptesService;

    public int count(comptes c){
        return commandeRepository.countCommandesByCompte(c);
    }

    public List<commande> getAllComm() {
        return commandeRepository.findAll();
    }

    public double calculateTotalBenefit() {
        List<commande> commands = commandeRepository.findAllByDelivered(true);
        double totalBenefit = 0.0;
        for (commande command : commands) {
            double commandBenefit = command.getP().getPrice() * command.getQuantity();
            totalBenefit += commandBenefit;
        }
        return totalBenefit;
    }
    public double calculateTotalBenefitPerMonth(String substring) {
        double totalBenefit = 0.0;
        List<commande> commands = commandeRepository.findByDateLivraisonContaining(substring);
        for (commande command : commands) {
            if (command.isDelivered()) {
                double commandBenefit = command.getP().getPrice() * command.getQuantity();
                totalBenefit += commandBenefit;
            }
        }
        return totalBenefit;
    }

    public int countCommByfiliere(String filiere){
        return commandeRepository.countByCompte_Filiere(filiere);
    }

    public commande getCommandById(Long id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Optional<commande> getCommandeById(Long id) {
        return commandeRepository.findById((Long)id);
    }

    public commande affecterLivreur(int id, int idD) {
        commande existingCommand = getCommandById((long)id);
        Optional<comptes> compteOpt = comptesService.getAccById((long)idD);
        comptes c = compteOpt.get();
        existingCommand.setDeliveryman(c);
        return commandeRepository.save(existingCommand);
    }


    public boolean createCommand(commande commande) {
        boolean res=false;
        try{
            commandeRepository.save(commande);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }


    public List<commande> findAllByPanierCompteEquals(comptes compte) {
        return commandeRepository.findAllByPanierCompteEquals(compte);
    }

    public commande updateDateAndLieu(int id, String date, String lieu, Boolean confirmed) {
        commande existingProduct = getCommandById((long)id);
        commande comm = new commande();
        comm.setDateLivraison(date);
        comm.setLieuLivraison(lieu);
        comm.setConfirmed(confirmed);
        existingProduct.setDateLivraison(comm.getDateLivraison());
        existingProduct.setLieuLivraison(comm.getLieuLivraison());
        existingProduct.setConfirmed(comm.getConfirmed());
        return commandeRepository.save(existingProduct);
    }

}
