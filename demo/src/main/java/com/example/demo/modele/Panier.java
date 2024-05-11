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
    @JoinColumn(name="account_id")
    private comptes compte;
    @ManyToOne
    @JoinColumn(name="commande_id")
    private commande commandes;
    @ManyToOne
    @JoinColumn(name="product_id")
    private produit prod;
}