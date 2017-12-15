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
		Client_dao db_client = new Client_daoImp(host, port, dataBaseName);
		Client myClient1 = new Client("Client1", "Anass", "BH001", "chbanianass@hotmail.com", "passwordClient");
		Client myClient2 = new Client("Client2", "Anass", "BH002", "chbanianass@hotmail.com", "passwordClient");
		Client myClient3 = new Client("Client3", "Anass", "BH003", "chbanianass@hotmail.com", "passwordClient");
		Client myClient4 = new Client("Client4", "Anass", "BH004", "chbanianass@hotmail.com", "passwordClient");
		Client myClient5 = new Client("Client5", "Anass", "BH005", "chbanianass@hotmail.com", "passwordClient");
		Client myClient6 = new Client("Client6", "Anass", "BH006", "chbanianass@hotmail.com", "passwordClient");
		Client myClient7 = new Client("Client7", "Anass", "BH007", "chbanianass@hotmail.com", "passwordClient");
		Client myClient8 = new Client("Client8", "Anass", "BH008", "chbanianass@hotmail.com", "passwordClient");
		Client myClient9 = new Client("Client9", "Anass", "BH009", "chbanianass@hotmail.com", "passwordClient");
		Client myClient10 = new Client("Client10", "Anass", "BH010", "chbanianass@hotmail.com", "passwordClient");
		Client myClient11 = new Client("Client11", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
		Client myClient12 = new Client("Client12", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
		Client myClient13 = new Client("Client13", "Anass", "BH473528", "chbanianass@hotmail.com", "passwordClient");
		if(db_client.ajouterClient(myClient1) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient2) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient3) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient4) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient5) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient6) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient7) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient8) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient9) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient10) != null){
			System.out.println("ajouterClient_test : done");
		}else{
			System.out.println("ajouterClient_test : null");
		}
		if(db_client.ajouterClient(myClient11) != null){
			System.out.println("ajouterClient_test : done");
		}else{
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
		//client_dao_test.getAllClient_test();
		//client_dao_test.modifierClient_test();
		//client_dao_test.supprimerClient_test();
	}
}
