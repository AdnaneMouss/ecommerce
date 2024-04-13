package com.example.demo.modele;

import jakarta.persistence.*;

@Entity
@Table(name ="products")
public class produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String label;
    @Column
    private String type;
    @Column
    private int price;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Entity
    public static class comptes {
        public comptes(Long id, String username, String email, int phone, String password) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.phone = phone;
            this.password = password;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String email;
        private int phone;
        private String password;

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

    }
}

