package com.example.demo.service;

import java.util.List;

public interface IDaocomptes {

    List<comptes> getAllComptes();

    comptes getCompteById(Long id);

    void addCompte(comptes copmte);

    void updateCompte(comptes compte);

    void deleteCompte(Long id);

}
