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
    private double price;
    @Column
    private String color;
    @Column
    private String photo;
    @Lob // This annotation is used to indicate that the property should be persisted as a large object (BLOB or CLOB) to the underlying database.
    @Column
    private byte[] pic;
    @Column
    private String size;
    @Column
    private int quantity;
    @Column
    private int rating;
    @ManyToOne
    @JoinColumn(name="category_id")
    private categorie categorie;

    public produit(int id, String label, double price, String color, String photo, int quantity,int rating, byte[]pic, String size, categorie categorie) {
        this.id = id;
        this.label = label;
        this.price = price;
        this.color = color;
        this.photo = photo;
        this.pic=pic;
        this.size = size;
        this.categorie = categorie;
        this.rating=rating;
        this.quantity=quantity;

    }

    public produit() {}

    public byte[] getPic() {
        return pic;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

