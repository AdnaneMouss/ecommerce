package com.example.demo.modele;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="commands")
public class commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="account_id")
    private comptes compte;
    @Column
    private String dateLivraison;
    @Column
    private String lieuLivraison;
    @Column
    private String méthodePaiement;

}