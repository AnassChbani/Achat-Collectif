package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Client_daoImp extends User_daoImp implements Client_dao {

	
	public Client_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	String COLLECTION_NAME = "User";
	@Override
	public void ajouterClient(Client client) {
		BasicDBObject myClient = this.myDB.createDocument();
		myClient.append(client.getId(), client);
		this.myDB.insertToCollection(COLLECTION_NAME, myClient);
	}

	@Override
	public void supprimerClient(Client client) {
		BasicDBObject myClient = this.myDB.createDocument();
		myClient.append(client.getId(), client);
		this.myDB.removeDocumentFromCollection(COLLECTION_NAME, myClient);
	}

	@Override
	public void modifierClient(Client oldclient, Client newclient) {
		// Not implemented yet
	}

	@Override
	public Client getClientByCin(String cin) {
		List<Client> lesClients = getAllClients();
		for (int i = 0; i < lesClients.size(); i++) {
			if(lesClients.get(i).getCin().equalsIgnoreCase(cin)){
				return lesClients.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		List<User> lesUsers = this.getAllUsers();
		List<Client> lesClients = new ArrayList<Client>();
		for (int i = 0; i < lesUsers.size(); i++) {
			if(lesUsers.get(i).isAdmin()){
				lesClients.add((Client) lesUsers.get(i));
			}
		}
		return lesClients;
	}

}
