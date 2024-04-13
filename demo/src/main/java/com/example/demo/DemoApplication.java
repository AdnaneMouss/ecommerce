package com.example.demo;

import com.example.demo.controller.ProduitController;
import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private final ProduitService produitService;
	private static ProduitController produitController=null;

	public DemoApplication(ProduitService produitService, ProduitController produitController) {
		this.produitService = produitService;
		this.produitController = produitController;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//testDeleteProduct();
		//testAddProduct();
		//testUpdateProduct();
		//testGetAllProducts();
	}

	// This method can be used for testing purposes
	public static void testGetAllProducts() {
		List<produit> all = produitController.getAllProduits();
		System.out.println(all);
	}
	public static void testDeleteProduct() {
		int id = 4;
    if(produitController.deleteProduit(id)) {
		System.out.println("Le produit n°:" + id + "\t a été supprimé avec succés");
	}
	else{
		System.out.println("Le produit n°:" + id + "\t n'existe pas!");
	}
	}
	public static void testAddProduct() {
		produit p1 = new produit();
		p1.setLabel("Product 1");
		p1.setType("Type 1");
		p1.setPrice(10);
        produitController.addProduct(p1);
	}

	public static void testUpdateProduct() {
		produit n = new produit(1,"",1,"","","","",null);
		produitController.updateProduit(2,n);
	}

}
