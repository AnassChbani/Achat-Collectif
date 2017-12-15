package com.achatCollectif.testDao;

import java.util.Date;
import java.util.List;

import com.achatCollectif.dao.Administrateur_dao;
import com.achatCollectif.dao.Administrateur_daoImp;
import com.achatCollectif.dao.Sujet_dao;
import com.achatCollectif.dao.Sujet_daoImp;
import com.achatCollectif.model.Administrateur;

public class Administrateur_dao_test extends Collections_dao_Test {
	
	public Administrateur_dao_test(){
		super();
	}
	
	public  void ajouterAdministrateur_test(){
		Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
		Administrateur myAdministrateur = new Administrateur( "Admin1", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordAdministrateur");
		Administrateur myAdministrateur2 = new Administrateur( "Admin2", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordAdministrateur");
		if(db_administrateur.ajouterAdministrateur(myAdministrateur) != null){
			System.out.println("ajouterAdministrateur_test : done");
		}else{
			System.out.println("ajouterAdministrateur_test : null");
		}
		if(db_administrateur.ajouterAdministrateur(myAdministrateur2) != null){
			System.out.println("ajouterAdministrateur_test : done");
		}else{
			System.out.println("ajouterAdministrateur_test : null");
		}
	}
	
	public  void supprimerAdministrateur_test(){
		Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
		Administrateur monAdministrateurASupprimer = db_administrateur.getAdministrateurByCin("cinAdministrateur0_new");
		if(db_administrateur.supprimerAdministrateur(monAdministrateurASupprimer) != null){
			System.out.println("TEST:supprimerAdministrateur_test : done");
		}else{
			System.out.println("TEST:supprimerAdministrateur_test : null");
		}	
	}
	
	public  void modifierAdministrateur_test(){
		Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
		Administrateur newAdministrateur = new Administrateur("comAdministrateur0_new","prenomAdministrateur0_new","cinAdministrateur0_new","emailAdministrateur0_new","passwordAdministrateur0_new");
		
		Administrateur oldAdministrateur = db_administrateur.getAdministrateurByCin("BH473528");
		if(db_administrateur.modifierAdministrateur(oldAdministrateur, newAdministrateur) != null){
			System.out.println("TEST:modifierAdministrateur_test : done");
		}else{
			System.out.println("TEST:modifierAdministrateur_test : null");
		}
	}
	
	public  void getAdministrateurbyId_test(){
		try {
			Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
			Administrateur myAdministrateur = db_administrateur.getAdministrateurByCin("id1");
			if(myAdministrateur != null){
				System.out.println("getAdministrateurbyId_test : "+myAdministrateur.toString());
			}else{
				System.out.println("getAdministrateurbyId_test : null");
			}
		} catch (Exception e) {
			System.out.println("getAdministrateurbyId_test : null");
		}
		
	}
	
	public void getAllAdministrateur_test(){
		Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
		List<Administrateur> listAdministrateur = db_administrateur.getAllAdministrateurs();
		if(listAdministrateur != null){
			System.out.println("getAllAdministrateur_test : "+listAdministrateur.toString());
		}else{
			System.out.println("getAllAdministrateur_test : null(vide)");
		}
	}
	
	public void supprimerTousLesAdministrateurs(){
		Administrateur_dao db_administrateur = new Administrateur_daoImp(host, port, dataBaseName);
		if(db_administrateur.supprimerToutLesAdministrateurs() == true){
			System.out.println("TEST:supprimerTousLesAdministrateurs : done");
		}else{
			System.out.println("TEST:supprimerTousLesAdministrateurs : null");
		}
	}
	
	public static void main(String[] args) {
		Administrateur_dao_test administrateur_dao_test = new Administrateur_dao_test();
		administrateur_dao_test.supprimerTousLesAdministrateurs();
		administrateur_dao_test.ajouterAdministrateur_test();
		//administrateur_dao_test.getAllAdministrateur_test();
		//administrateur_dao_test.modifierAdministrateur_test();
		//administrateur_dao_test.supprimerAdministrateur_test();
	}
}
