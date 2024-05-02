package com.example.demo.modele;


import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class comptes {
    public comptes(int id, String username, String email, int phone, String password, String type, String photo,String filiere,String nom){
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.photo = photo;
        this.filiere= filiere ;
        this.nom = nom ;
    }
    public comptes(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private int phone;
    private String password;
    private String type;
    private String photo;
    private String nom;
    private String filiere;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}