package com.achatCollectif.testDao;

import java.util.List;

import com.achatCollectif.model.Categorie;

public class Categorie_dao_test extends Collections_dao_Test{
	
	public Categorie_dao_test(){
		super();
	}
	/*
	public static void main(String[] args) {
		System.out.println("=====================================");
		Categorie_dao_test categorie_dao_test = new Categorie_dao_test();
		categorie_dao_test.supprimerAllCaterories();
		categorie_dao_test.ajouterCategorie();
		//categorie_dao_test.getCategorieById();
		//categorie_dao_test.getAllCategories();
		//categorie_dao_test.modifierCategorie();
		//categorie_dao_test.getAllCategories();
		//categorie_dao_test.supprimerCategorie();
		//categorie_dao_test.getAllCategories();
		System.out.println("=====================================");
	}

	private void supprimerAllCaterories() {
		Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
		if(db_categorie.supprimerToutLesCategories() == true){
			System.out.println("TEST:supprimerAllCaterories : done");
		}else{
			System.out.println("TEST:supprimerAllCaterories : null");
		}
	}
	
	private void getAllCategories() {
		try {
			Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
			List<Categorie> listCategorie = db_categorie.getAllCategories();
			if(listCategorie != null){
				System.out.println("TEST:getAllCategories : "+listCategorie.toString());
			}else{
				System.out.println("TEST:getAllCategories : null");
			}
		} catch (Exception e) {
			System.out.println("TEST:getAllCategories : null");
		}
	}

	private void getCategorieById() {
		Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
		Categorie maCategorie = db_categorie.getCategorieById("id1");
		if(maCategorie != null){
			System.out.println("TEST:getCategorieById : "+maCategorie.toString());
		}else{
			System.out.println("TEST:getCategorieById : null");
		}
	}

	private void modifierCategorie() {
		Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
		Categorie newCategorie = new Categorie("id2", "LibelleCategorieTest_AfterUpdate");
		Categorie oldCategorie = db_categorie.getCategorieById("id1");
		if(db_categorie.modifierCategorie(oldCategorie, newCategorie) != null){
			System.out.println("TEST:modifierCategorie : done");
		}else{
			System.out.println("TEST:modifierCategorie : null");
		}
	}
	
	private void ajouterCategorie() {
		Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
		Categorie maCategorie = new Categorie( "ElectroMénager");
		Categorie maCategorie1 = new Categorie( "Convoiturage");
		Categorie maCategorie2 = new Categorie( "Hôtelerie");
		Categorie maCategorie3 = new Categorie( "Formation");
		Categorie maCategorie4 = new Categorie("Immobilier");
		Categorie maCategorie5 = new Categorie( "Tourisme");
		
		
		
		if(db_categorie.ajouterCategorie(maCategorie) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
		if(db_categorie.ajouterCategorie(maCategorie1) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
		if(db_categorie.ajouterCategorie(maCategorie2) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
		if(db_categorie.ajouterCategorie(maCategorie3) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
		if(db_categorie.ajouterCategorie(maCategorie4) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
		if(db_categorie.ajouterCategorie(maCategorie5) != null){
			System.out.println("TEST:ajouterCategorie : done");
		}else{
			System.out.println("TEST:ajouterCategorie : null");
		}
	}
	
	private void supprimerCategorie() {
		Categorie_dao db_categorie = new Categorie_daoImp(host, port, dataBaseName);
		Categorie maCategorie = new Categorie("id1", "LibelleCategorieTest");
		if(db_categorie.supprimerCategorie(maCategorie) != null){
			System.out.println("TEST:supprimerCategorie : done");
		}else{
			System.out.println("TEST:supprimerCategorie : null");
		}		
	}
   /**/
}
