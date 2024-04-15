package com.example.demo.modele;


import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class comptes {
    public comptes(Long id, String username, String email, int phone, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.photo = photo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private int phone;
    private String password;
    private int type;
    private Long photo;

    public comptes() {

    }
    // autres champs et méthodes

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPhonenumber() {
        return phone;
    }

    public void setPhonenumber(int Phonenumber ) {
        this.phone = Phonenumber;
    }

    public String getPassword() {
        return getPassword();
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public int getType() {
        return type;
    }

    public Long getPhoto() {
        return photo;
    }
}
