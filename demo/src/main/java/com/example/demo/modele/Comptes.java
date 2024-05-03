package com.example.demo.modele;
import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
@Table(name="comptes")
public class Comptes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String email;
    private  String filiere;
    private  String nom;
    private String password;
    private  int num;
    private  String photo;
    private  String type;
    private String username;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Comptes() {}
    public Comptes(int id, String email, String filiere, String nom, String password, int num, String photo, String type, String username) {
        this.id = id;
        this.email = email;
        this.filiere = filiere;
        this.nom = nom;
        this.password = password;
        this.num = num;
        this.photo = photo;
        this.type = type;
        this.username = username;
    }
    @Override
    public String toString() {
        return "Comptes{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", filiere='" + filiere + '\'' +
                ", nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                ", num=" + num +
                ", photo='" + photo + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
