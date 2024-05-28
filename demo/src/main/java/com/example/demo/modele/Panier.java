package com.example.demo.modele;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name ="panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private comptes compte;
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<commande> commandes;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public comptes getCompte() {
        return compte;
    }
    public void setCompte(comptes compte) {
        this.compte = compte;
    }
    public Panier() {
    }
    public Panier(int id, comptes compte) {
        this.id = id;
        this.compte = compte;
    }
    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", compte=" + compte +
                ", commandes=" + commandes;
    }
}