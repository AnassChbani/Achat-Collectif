package com.achatCollectif.test;

import java.util.List;

import com.achatCollectif.dao.*;
import com.achatCollectif.model.Administrateur;

public class Administrateur_dao_test extends Collections_dao_Test {
	
	public Administrateur_dao_test(){
		super();
	}
	
	public static void ajouterAdmin_test(){
		try {
			Administrateur_dao db_admin = new Administrateur_daoImp(host, port, dataBaseName);
			Administrateur myAdmin = new Administrateur("id1", "Chbani", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordAdmin");
			db_admin.ajouterAdmin(myAdmin);
			System.out.println("ajouterAdmin_test : done");
		} catch (Exception e) {
			System.out.println("ajouterAdmin_test : null");
		}
	}
	
	public static void supprimerAdmin_test(){
		try {
			Administrateur_dao db_admin = new Administrateur_daoImp(host, port, dataBaseName);
			Administrateur myAdmin = new Administrateur("id1", "Chbani", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordAdmin");
			db_admin.supprimerAdmin(myAdmin);
			System.out.println("supprimerAdmin_test : done");
		} catch (Exception e) {
			System.out.println("supprimerAdmin_test : null");
		}
	}
	
	public static void modifierAdmin_test(){
		//Not implemented yet
	}
	
	public static void getAdminbyId_test(){
		try {
			Administrateur_dao db_admin = new Administrateur_daoImp(host, port, dataBaseName);
			Administrateur myAdmin = db_admin.getAdministrateurByCin("id1");
			if(myAdmin != null){
				System.out.println("getAdminbyId_test : "+myAdmin.toString());
			}else{
				System.out.println("getAdminbyId_test : null");
			}
		} catch (Exception e) {
			System.out.println("getAdminbyId_test : null");
		}
		
	}
	
	public static void getAllAdmin_test(){
		try {
			Administrateur_dao db_admin = new Administrateur_daoImp(host, port, dataBaseName);
			List<Administrateur> listAdmin = db_admin.getAllAdmins();
			if(listAdmin != null){
				System.out.println("getAllAdmin_test : "+listAdmin.toString());
			}else{
				System.out.println("getAllAdmin_test : null");
			}	
		} catch (Exception e) {
			System.out.println("getAllAdmin_test : null");
		}
	}
	
	public static void main(String[] args) {
		Administrateur_dao_test.ajouterAdmin_test();
		Administrateur_dao_test.getAdminbyId_test();
		Administrateur_dao_test.getAllAdmin_test();
		Administrateur_dao_test.modifierAdmin_test();
		Administrateur_dao_test.supprimerAdmin_test();
	}
}
