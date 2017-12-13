package com.achatCollectif.test;

import java.util.Date;
import java.util.List;

import com.achatCollectif.dao.Categorie_dao;
import com.achatCollectif.dao.Categorie_daoImp;
import com.achatCollectif.dao.Client_dao;
import com.achatCollectif.dao.Client_daoImp;
import com.achatCollectif.dao.Sujet_dao;
import com.achatCollectif.dao.Sujet_daoImp;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public class Sujet_dao_test extends Collections_dao_Test {
	
	public Sujet_dao_test(){
		super();
	}
	
	public void ajouterSujet_test(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet monSujet = new Sujet("id1", "libelleSujetTest", "DescriptionSujetTest", 90, new Date(23,03,1995), new Date(23,03,2017), "imageProduitTest", "NotePourTester", "id1", "id1");
		if(db_sujet.ajouterSujet(monSujet) != null){
			System.out.println("TEST:ajouterSujet_test : done");
		}else{
			System.out.println("TEST:ajouterSujet_test : null");
		}
	}
	
	public void supprimerSujet(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet monSujet = db_sujet.getSujetById("id1");
		if(db_sujet.supprimerSujet(monSujet) != null){
			System.out.println("TEST:supprimerSujet : done");
		}else{
			System.out.println("TEST:supprimerSujet : null");
		}		
	}
	
	public void modifierSujet(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet newSujet = new Sujet("id2", "libelleSujetTest", "DescriptionSujetTest", 90, new Date(23,03,1995), new Date(23,03,2017), "imageProduitTest", "NotePourTester", "id1", "id1");

		Sujet oldSujet = db_sujet.getSujetById("id1");
		if(db_sujet.modifierSujet(oldSujet, newSujet) != null){
			System.out.println("TEST:modifierSujet : done");
		}else{
			System.out.println("TEST:modifierSujet : null");
		}
	}
	
	public void getSujetById_test(){
		Sujet_dao db_sujet = new Sujet_daoImp(host, port, dataBaseName);
		Sujet monSujet = db_sujet.getSujetById("id1");
		if(monSujet != null){
			System.out.println("TEST:getSujetById_test : "+monSujet.toString());
		}else{
			System.out.println("TEST:getSujetById_test : null");
		}
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
		sujet_dao_test.getSujetById_test();
		sujet_dao_test.getAllSujets_test();
		sujet_dao_test.modifierSujet();
		sujet_dao_test.getAllSujets_test();
		sujet_dao_test.supprimerSujet();
		sujet_dao_test.getAllSujets_test();
		System.out.println("=====================================");
	}

}