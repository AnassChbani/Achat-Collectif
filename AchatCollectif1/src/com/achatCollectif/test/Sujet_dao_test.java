package com.achatCollectif.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.achatCollectif.dao.Categorie_dao;
import com.achatCollectif.dao.Categorie_daoImp;
import com.achatCollectif.dao.Client_dao;
import com.achatCollectif.dao.Client_daoImp;
import com.achatCollectif.dao.Sujet_dao;
import com.achatCollectif.dao.Sujet_daoImp;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public class Sujet_dao_test extends Collections_dao_Test {
	
	public Sujet_dao_test(){
		super();
	}
	
	public void ajouterSujet_test(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		List<User> listAdherents = new ArrayList<User>();
		Client c0 = new Client("comClient0","prenomClient0","cinClient0","emailClient0","passwordClient0");
		Client c1 = new Client("comClient1","prenomClient1","cinClient1","emailClient1","passwordClient1");
		Client c2 = new Client("comClient2","prenomClient2","cinClient2","emailClient2","passwordClient2");
		Client c3 = new Client("comClient3","prenomClient3","cinClient3","emailClient3","passwordClient3");
		
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		db_client.ajouterClient(c0);
		db_client.ajouterClient(c1);
	    db_client.ajouterClient(c2);
		db_client.ajouterClient(c3);
		
		Client db_c0 = db_client.getClientByCin("cinClient0");
		Client db_c1 = db_client.getClientByCin("cinClient1");
		Client db_c2 = db_client.getClientByCin("cinClient2");
		Client db_c3 = db_client.getClientByCin("cinClient3");
		
		listAdherents.add(db_c0);
		listAdherents.add(db_c1);
		listAdherents.add(db_c2);
		listAdherents.add(db_c3);
		
		List<Commentaire> listCommentaires = new ArrayList<Commentaire>();
		listCommentaires.add(new Commentaire("Commentaire 0", db_c0));
		listCommentaires.add(new Commentaire("Commentaire 1", db_c1));
		listCommentaires.add(new Commentaire("Commentaire 2", db_c2));
		listCommentaires.add(new Commentaire("Commentaire 3", db_c3));
		Sujet monSujet = new Sujet("libelleSujetTest",
				"DescriptionSujetTest",
				900,
				new Date(23,03,1995), 
				new Date(23,03,2017),
				"imageProduitTest", 
				"NotePourTester", 
				"idProprietaire",
				"idCategorie",
				listAdherents,
				listCommentaires
				);
		if(db_sujet.ajouterSujet(monSujet) != null){
			System.out.println("TEST:ajouterSujet_test : done");
		}else{
			System.out.println("TEST:ajouterSujet_test : null");
		}
	}
	
	public void supprimerSujet(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet SujetToDelete = new Sujet("SujetToDelete", "DescriptionSujetTest", 90, new Date(23,03,1995), new Date(23,03,2017), "imageProduitTest", "NotePourTester", "id1", "id1");
		Sujet SujetToDeletedb=db_sujet.ajouterSujet(SujetToDelete);
		
		System.out.println("Testing : "+SujetToDeletedb.toString());
		if(db_sujet.supprimerSujet(SujetToDeletedb) != null){
			System.out.println("TEST:supprimerSujet : done");
		}else{
			System.out.println("TEST:supprimerSujet : null");
		}		
	}
	
	public void modifierSujet(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet oldSujet = new Sujet("libelleSujetTest", "DescriptionSujetTest", 90, new Date(23,03,1995), new Date(23,03,2017), "imageProduitTest", "NotePourTester", "id1", "id1");
		oldSujet=db_sujet.ajouterSujet(oldSujet);
		Sujet newSujet = new Sujet("libelleSujetTest_modifiéé", "DescriptionSujetTest", 90, new Date(23,03,1995), new Date(23,03,2017), "imageProduitTest", "NotePourTester", "id1", "id1");
		
		if(db_sujet.modifierSujet(oldSujet, newSujet) != null){
			System.out.println("TEST:modifierSujet : done");
		}else{
			System.out.println("TEST:modifierSujet : null");
		}
	}
	
	public void getSujetById_test(){
		//Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		//Sujet monSujet = db_sujet.getSujetById("id1");
		//if(monSujet != null){
		//	System.out.println("TEST:getSujetById_test : "+monSujet.toString());
		//}else{
		//	System.out.println("TEST:getSujetById_test : null");
		//}
	}
	
	public void getAllSujets_test(){
		try {
			Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
			List<Sujet> listSujets = db_sujet.getAllSujets();
			if(listSujets != null){
				System.out.println("TEST:getAllSujets_test : "+listSujets.toString());
			}else{
				System.out.println("TEST:getAllSujets_test : null");
			}
		} catch (Exception e) {
			System.out.println("TEST:getAllSujets_test : null");
		}
	}
	
	private void supprimerToutLesSujets() {
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		if(db_sujet.supprimerToutLesSujet() == true){
			System.out.println("TEST:supprimerAllSujets : done");
		}else{
			System.out.println("TEST:supprimerAllSujets : null");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("=====================================");
		Sujet_dao_test sujet_dao_test = new Sujet_dao_test();
		sujet_dao_test.supprimerToutLesSujets();
		sujet_dao_test.ajouterSujet_test();
		//sujet_dao_test.getSujetById_test();
		sujet_dao_test.getAllSujets_test();
		sujet_dao_test.modifierSujet();
		//sujet_dao_test.getAllSujets_test();
		sujet_dao_test.supprimerSujet();
		//sujet_dao_test.getAllSujets_test();
		System.out.println("=====================================");
	}

}