package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class User_daoImp extends MyCollection implements User_dao {

	String COLLECTION_NAME = "User";
	public User_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getAllUsers() {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		List<User> lesUsers = new ArrayList<User>();
		for (int i = 0; i < myDocumentsList.size(); i++) {
			lesUsers.add(
					createUserFromDBObject((BasicDBObject)myDocumentsList.get(i))
				);
		}
		return lesUsers;
	}

	@Override
	public User getUserByCin(String cin) {
		List<User> lesUsers = getAllUsers();
		for (int i = 0; i < lesUsers.size(); i++) {
			if(lesUsers.get(i).getCin().equalsIgnoreCase(cin)){
				return lesUsers.get(i);
			}
		}
		return null;
	}

	@Override
	public User getUserById(String id) {
		List<User> lesUsers = getAllUsers();
		for (int i = 0; i < lesUsers.size(); i++) {
			if(lesUsers.get(i).getId().equalsIgnoreCase(id)){
				return lesUsers.get(i);
			}
		}
		return null;
	}

	
	public User createUserFromDBObject(BasicDBObject dbObject){
		String id = dbObject.getString("_id");
		String nom = dbObject.getString("nom");
		String prenom = dbObject.getString("prenom");
		String email = dbObject.getString("email");
		String cin = dbObject.getString("cin");
		String password = dbObject.getString("password");
		boolean estAdmin = dbObject.getBoolean("estAdmin");
		
		return new User(id, nom, prenom, cin, email, password, estAdmin);		
	}
}
