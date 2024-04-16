package com.example.demo.service;

import com.example.demo.modele.comptes;

import java.util.List;

public interface IDaocomptes {

    List<comptes> getAllComptes();

    comptes getCompteById(int id);

    void addCompte(comptes copmte);

    void updateCompte(comptes compte);

    void deleteCompte(int id);

}
