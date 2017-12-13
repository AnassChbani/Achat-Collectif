package com.achatCollectif.test;

import java.util.List;

import com.achatCollectif.dao.Client_dao;
import com.achatCollectif.dao.Client_daoImp;
import com.achatCollectif.model.Client;

public class Client_dao_test extends Collections_dao_Test {
	
	public Client_dao_test(){
		super();
	}
	
	public static void ajouterClient_test(){
		try {
			Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
			Client myClient = new Client("id2", "Chbani", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
			db_client.ajouterClient(myClient);
			System.out.println("ajouterClient_test : done");
		} catch (Exception e) {
			System.out.println("ajouterClient_test : null");
		}
	}
	
	public static void supprimerClient_test(){
		try {
			Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
			Client myClient = new Client("id1", "Chbani", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
			db_client.supprimerClient(myClient);
			System.out.println("supprimerClient_test : done");
		} catch (Exception e) {
			System.out.println("supprimerClient_test : null");
		}
	}
	
	public static void modifierClient_test(){
		//Not implemented yet
	}
	
	public static void getClientbyId_test(){
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
	
	public static void getAllClient_test(){
		try {
			Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
			List<Client> listClient = db_client.getAllClients();
			if(listClient != null){
				System.out.println("getAllClient_test : "+listClient.toString());
			}else{
				System.out.println("getAllClient_test : null");
			}	
		} catch (Exception e) {
			System.out.println("getAllClient_test : null");
		}
	}
	
	public static void main(String[] args) {
		Client_dao_test.ajouterClient_test();
		Client_dao_test.getClientbyId_test();
		Client_dao_test.getAllClient_test();
		Client_dao_test.modifierClient_test();
		Client_dao_test.supprimerClient_test();
	}
}
