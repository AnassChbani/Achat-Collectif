package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Administrateur_daoImp extends User_daoImp implements Administrateur_dao {

	String COLLECTION_NAME = "User";
	
	public Administrateur_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	@Override
	public void ajouterAdmin(Administrateur admin) {
		BasicDBObject myAdmin = this.myDB.createDocument();
		myAdmin.append(admin.getId(), admin);
		this.myDB.insertToCollection(COLLECTION_NAME, myAdmin);
	}

	@Override
	public void supprimerAdmin(Administrateur admin) {
		BasicDBObject myAdmin = this.myDB.createDocument();
		myAdmin.append(admin.getId(), admin);
		this.myDB.removeDocumentFromCollection(COLLECTION_NAME, myAdmin);
	}

	@Override
	public void modifierAdmin(Administrateur oldAdmin, Administrateur newAdmin) {
		BasicDBObject myOldAdmin = this.myDB.createDocument();
		BasicDBObject myNewAdmin = this.myDB.createDocument();
		myOldAdmin.append(oldAdmin.getId(), oldAdmin);
		myNewAdmin.append(newAdmin.getId(), newAdmin);
		//this.myDB.updateCollection(COLLECTION_NAME, myOldAdmin, myNewAdmin);
	}

	@Override
	public List<Administrateur> getAllAdmins() {
		List<User> lesUsers = this.getAllUsers();
		List<Administrateur> lesAdministrateurs = new ArrayList<Administrateur>();
		for (int i = 0; i < lesUsers.size(); i++) {
			if(lesUsers.get(i).isAdmin()){
				lesAdministrateurs.add((Administrateur) lesUsers.get(i));
			}
		}
		return lesAdministrateurs;
	}

	@Override
	public Administrateur getAdministrateurByCin(String cin) {
		List<Administrateur> lesAdministrateurs = getAllAdmins();
		for (int i = 0; i < lesAdministrateurs.size(); i++) {
			if(lesAdministrateurs.get(i).getCin().equalsIgnoreCase(cin)){
				return lesAdministrateurs.get(i);
			}
		}
		return null;
	}

}
