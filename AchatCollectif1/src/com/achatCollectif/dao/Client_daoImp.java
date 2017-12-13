package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Client_daoImp extends User_daoImp implements Client_dao {

	
	public Client_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	String COLLECTION_NAME = "User";
	@Override
	public Client ajouterClient(Client client) {
		BasicDBObject db_sujet = createDBObjectFromClient(client); 
		if(this.getClientObject(client) == null){
			if(this.myDB.insertToCollection(COLLECTION_NAME, db_sujet) != null){
				return client;
			}else{ 
				return null;
			}	
		}else{
			return null;
		}
	}

	@Override
	public Client supprimerClient(Client client) {
		if(client!=null){
			BasicDBObject myClient = this.getClientObject(client);
			if(myClient != null){
				if(this.myDB.removeDocumentFromCollection(COLLECTION_NAME, myClient) == true){
					return client;
				}else{
					return null;
				}
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Client modifierClient(Client oldclient, Client newclient) {
		BasicDBObject oldObject = createDBObjectFromClient(oldclient);
	    BasicDBObject newObject = createDBObjectFromClient(newclient);
	    if(oldObject != null && newObject!=null){
	    	if(this.myDB.updateCollection(COLLECTION_NAME, oldObject, newObject) != null){
				return newclient;
			}else{ 
				return null;
			}
	    }else{
	    	return null;
	    }
	}

	private BasicDBObject createDBObjectFromClient(Client client) {
		BasicDBObject dbObjectclient = new BasicDBObject();
		dbObjectclient.append("nom", client.getNom());
		dbObjectclient.append("prenom", client.getPrenom() );
		dbObjectclient.append("cin", client.getCin());
		dbObjectclient.append("email", client.getEmail());
		dbObjectclient.append("password", client.getPassword());
		dbObjectclient.append("estAdmin", client.isAdmin());
		return dbObjectclient;
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
			if(lesUsers.get(i).isAdmin() == false){
				lesClients.add(new Client(lesUsers.get(i).getId(),
						lesUsers.get(i).getNom(), 
						lesUsers.get(i).getPrenom(),
						lesUsers.get(i).getCin(),
						lesUsers.get(i).getEmail(),
						lesUsers.get(i).getPassword()));
			}
		}
		return lesClients;
	}

	@Override
	public BasicDBObject getClientObject(Client client) {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		BasicDBObject clientObject = null;
		for (int i = 0; i < myDocumentsList.size(); i++) {
			clientObject = (BasicDBObject) myDocumentsList.get(i);
			if (clientObject.get("_id").toString().equalsIgnoreCase(client.getId())) {
				return clientObject;
			}
		}
		return null;
	}

	@Override
	public boolean supprimerToutLesClients() {
		List<Client> listClients = this.getAllClients();
		if(listClients != null){
			for (int i = 0; i < listClients.size(); i++) {
				this.supprimerClient(listClients.get(i));
			}
			listClients = this.getAllClients();
			if(listClients.size() == 0 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}

	}

}
