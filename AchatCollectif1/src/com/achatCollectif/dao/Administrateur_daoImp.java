package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Administrateur_daoImp extends User_daoImp implements Administrateur_dao {

	public Administrateur_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	String COLLECTION_NAME = "User";
	@Override
	public Administrateur ajouterAdministrateur(Administrateur administrateur) {
		BasicDBObject db_sujet = createDBObjectFromAdministrateur(administrateur); 
		if(this.getAdministrateurObject(administrateur) == null){
			BasicDBObject insertedAdmin = this.myDB.insertToCollection(COLLECTION_NAME, db_sujet);
			User user = createUserFromDBObject(insertedAdmin);
			if( insertedAdmin != null){
				Administrateur admin = new Administrateur(user.getId(),user.getNom(), user.getPrenom(),
						user.getCin(), user.getEmail(), user.getPassword()); 
				return admin;
			}else{ 
				return null;
			}	
		}else{
			return null;
		}
	}

	@Override
	public Administrateur supprimerAdministrateur(Administrateur administrateur) {
		if(administrateur!=null){
			BasicDBObject myAdministrateur = this.getAdministrateurObject(administrateur);
			if(myAdministrateur != null){
				if(this.myDB.removeDocumentFromCollection(COLLECTION_NAME, myAdministrateur) == true){
					return administrateur;
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
	public Administrateur modifierAdministrateur(Administrateur oldadministrateur, Administrateur newadministrateur) {
		BasicDBObject oldObject = createDBObjectFromAdministrateur(oldadministrateur);
		BasicDBObject newObject = createDBObjectFromAdministrateur(newadministrateur);
	    if(oldObject != null && newObject!=null){
	    	if(this.myDB.updateCollection(COLLECTION_NAME, oldObject, newObject) != null){
				return newadministrateur;
			}else{ 
				return null;
			}
	    }else{
	    	return null;
	    }
	}

	private BasicDBObject createDBObjectFromAdministrateur(Administrateur administrateur) {
		BasicDBObject dbObjectadministrateur = new BasicDBObject();
		dbObjectadministrateur.append("nom", administrateur.getNom());
		dbObjectadministrateur.append("prenom", administrateur.getPrenom() );
		dbObjectadministrateur.append("cin", administrateur.getCin());
		dbObjectadministrateur.append("email", administrateur.getEmail());
		dbObjectadministrateur.append("password", administrateur.getPassword());
		dbObjectadministrateur.append("estAdmin", administrateur.isAdmin());
		return dbObjectadministrateur;
	}

	@Override
	public Administrateur getAdministrateurByCin(String cin) {
		List<Administrateur> lesAdministrateurs = getAllAdministrateurs();
		for (int i = 0; i < lesAdministrateurs.size(); i++) {
			if(lesAdministrateurs.get(i).getCin().equalsIgnoreCase(cin)){
				return lesAdministrateurs.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Administrateur> getAllAdministrateurs() {
		List<User> lesUsers = this.getAllUsers();
		List<Administrateur> lesAdministrateurs = new ArrayList<Administrateur>();
		for (int i = 0; i < lesUsers.size(); i++) {
			if(lesUsers.get(i).isAdmin() == true){
				lesAdministrateurs.add(new Administrateur(lesUsers.get(i).getId(),
						lesUsers.get(i).getNom(), 
						lesUsers.get(i).getPrenom(),
						lesUsers.get(i).getCin(),
						lesUsers.get(i).getEmail(),
						lesUsers.get(i).getPassword()));
			}
		}
		return lesAdministrateurs;
	}

	@Override
	public BasicDBObject getAdministrateurObject(Administrateur administrateur) {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		BasicDBObject administrateurObject = null;
		for (int i = 0; i < myDocumentsList.size(); i++) {
			administrateurObject = (BasicDBObject) myDocumentsList.get(i);
			if (administrateurObject.get("_id").toString().equalsIgnoreCase(administrateur.getId())) {
				return administrateurObject;
			}
		}
		return null;
	}

	@Override
	public boolean supprimerToutLesAdministrateurs() {
		List<Administrateur> listAdministrateurs = this.getAllAdministrateurs();
		if(listAdministrateurs != null){
			for (int i = 0; i < listAdministrateurs.size(); i++) {
				this.supprimerAdministrateur(listAdministrateurs.get(i));
			}
			listAdministrateurs = this.getAllAdministrateurs();
			if(listAdministrateurs.size() == 0 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}

	}

}
