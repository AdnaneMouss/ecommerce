package com.example.demo.modele;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Reclamation {
    public Reclamation(int id, String description, String nomUtilisateur) {
        this.description = description;
        this.nomUtilisateur = nomUtilisateur;
    }
    public Reclamation(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @Column
    private String nomUtilisateur;

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getnomUtilisateur() {
        return nomUtilisateur;
    }

    public void setnomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

