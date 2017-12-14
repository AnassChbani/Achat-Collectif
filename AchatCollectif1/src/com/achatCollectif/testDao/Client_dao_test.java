package com.achatCollectif.testDao;

import java.util.Date;
import java.util.List;

import com.achatCollectif.dao.Client_dao;
import com.achatCollectif.dao.Client_daoImp;
import com.achatCollectif.dao.Sujet_dao;
import com.achatCollectif.dao.Sujet_daoImp;
import com.achatCollectif.model.Client;

public class Client_dao_test extends Collections_dao_Test {
	
	public Client_dao_test(){
		super();
	}
	
	public  void ajouterClient_test(){
		try {
			Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
			Client myClient = new Client("id2", "Chbani", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
			db_client.ajouterClient(myClient);
			System.out.println("ajouterClient_test : done");
		} catch (Exception e) {
			System.out.println("ajouterClient_test : null");
		}
	}
	
	public  void supprimerClient_test(){
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		Client monClientASupprimer = db_client.getClientByCin("cinClient0_new");
		if(db_client.supprimerClient(monClientASupprimer) != null){
			System.out.println("TEST:supprimerClient_test : done");
		}else{
			System.out.println("TEST:supprimerClient_test : null");
		}	
	}
	
	public  void modifierClient_test(){
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		Client newClient = new Client("comClient0_new","prenomClient0_new","cinClient0_new","emailClient0_new","passwordClient0_new");
		
		Client oldClient = db_client.getClientByCin("BH473528");
		if(db_client.modifierClient(oldClient, newClient) != null){
			System.out.println("TEST:modifierClient_test : done");
		}else{
			System.out.println("TEST:modifierClient_test : null");
		}
	}
	
	public  void getClientbyId_test(){
		try {
			Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
			Client myClient = db_client.getClientByCin("id1");
			if(myClient != null){
				System.out.println("getClientbyId_test : "+myClient.toString());
			}else{
				System.out.println("getClientbyId_test : null");
			}
		} catch (Exception e) {
			System.out.println("getClientbyId_test : null");
		}
		
	}
	
	public void getAllClient_test(){
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		List<Client> listClient = db_client.getAllClients();
		if(listClient != null){
			System.out.println("getAllClient_test : "+listClient.toString());
		}else{
			System.out.println("getAllClient_test : null(vide)");
		}
	}
	
	public void supprimerTousLesClients(){
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		if(db_client.supprimerToutLesClients() == true){
			System.out.println("TEST:supprimerTousLesClients : done");
		}else{
			System.out.println("TEST:supprimerTousLesClients : null");
		}
	}
	
	public static void main(String[] args) {
		Client_dao_test client_dao_test = new Client_dao_test();
		client_dao_test.supprimerTousLesClients();
		client_dao_test.ajouterClient_test();
		//Client_dao_test.getClientbyId_test();
		client_dao_test.getAllClient_test();
		client_dao_test.modifierClient_test();
		client_dao_test.supprimerClient_test();
	}
}
