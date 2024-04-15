package com.example.demo.modele;

import jakarta.persistence.*;

@Entity
@Table(name ="products")
public class produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String label;
    @Column
    private int price;
    @Column
    private String color;
    @Column
    private String photo;
    @Column
    private String size;
    @ManyToOne
    @JoinColumn(name="category_id")
    private categorie categorie;

    public produit(int id, String label, int price, String color, String photo, String size, categorie categorie) {
        this.id = id;
        this.label = label;
        this.price = price;
        this.color = color;
        this.photo = photo;
        this.size = size;
        this.categorie = categorie;
    }

    public produit() {}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public com.example.demo.modele.categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(com.example.demo.modele.categorie categorie) {
        this.categorie = categorie;
    }
}

