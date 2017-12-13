package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.User;
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
					new Administrateur(
					myDocumentsList.get(i).get("id").toString(), 
					myDocumentsList.get(i).get("nom").toString(),
					myDocumentsList.get(i).get("prenom").toString(),
					myDocumentsList.get(i).get("cin").toString(),
					myDocumentsList.get(i).get("email").toString(),
					myDocumentsList.get(i).get("password").toString()
					)
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

}
