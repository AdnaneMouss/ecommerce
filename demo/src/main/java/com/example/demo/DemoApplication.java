package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private final ProduitService produitService;
	private static ProduitController produitController=null;
	private static CategorieController categorieController=null;

	public DemoApplication(ProduitService produitService, ProduitController produitController,CategorieController categorieController) {
		this.produitService = produitService;
		this.produitController = produitController;
		this.categorieController = categorieController;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//testDeleteProduct();
		//testAddProduct();
		//testUpdateProduct();
		//testGetAllProducts();
		//testAddCategory();
		//testDeleteCategory();
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
		produit p1 = new produit(0,"Adkd",1,"","","",null);
		if(produitController.addProduct(p1)) {
			System.out.println("Le produit:" + p1 + "\t a été ajouté avec succés");
		}
		else{
			System.out.println("Erreur lors de l'ajout!");
		}
	}

	public static void testUpdateProduct() {
		int idProduitAModifier=2;
		produit prod = new produit(0,"",1,"fgh","","",null);
		if(produitController.updateProduit(idProduitAModifier,prod)){
		System.out.println("Le produit a été mis à jour");
	}
		else{
		System.out.println("Erreur!");
	}
	}

	//---------------Catégories--------------------

	public static void testAddCategory() {
		String name = "";
		categorie c = new categorie(0,name);
		if((categorieController.addCategorie(c))) {
			System.out.println("La categorie:" + c + "\t a été ajouté avec succés");
		}
		else{
			System.out.println("Erreur lors de l'ajout!");
		}
	}

	public static void testDeleteCategory() {
		int id = 4;
		if(categorieController.deleteCategorie(id)) {
			System.out.println("La catégorie n°:" + id + "\t a été supprimé avec succés");
		}
		else{
			System.out.println("Le catégorie n°:" + id + "\t n'existe pas!");
		}
	}

	public static void testGetAllCategories() {
		List<categorie> all = categorieController.getAllCategories();
		System.out.println(all);
	}

}
