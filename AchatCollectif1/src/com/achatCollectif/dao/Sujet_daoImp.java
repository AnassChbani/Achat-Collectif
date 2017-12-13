package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Sujet_daoImp extends MyCollection implements Sujet_dao {

	String COLLECTION_NAME = "Sujet";
	
	
	public Sujet_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	@Override
	public Sujet ajouterSujet(Sujet sujet) {
		BasicDBObject db_sujet = new BasicDBObject(); 
		db_sujet.append("id",sujet.getId());
		db_sujet.append("libelle",sujet.getLibelle());
		db_sujet.append("description",sujet.getDescription());
		db_sujet.append("prix",sujet.getPrix());
		db_sujet.append("dateDepo",sujet.getDateDepo());
		db_sujet.append("dateExtra",sujet.getDateExtra());
		db_sujet.append("image",sujet.getImage());
		db_sujet.append("note",sujet.getNote());
		db_sujet.append("idUser",sujet.getPropietaire());
		db_sujet.append("idCategorie",sujet.getCategorie());
		
		List<String> listAdhents = null;
		if(sujet.getListAdherent() != null){
			for (int i = 0; i < sujet.getListAdherent().size(); i++) {
				listAdhents.add(sujet.getListAdherent().get(i));
			}
			db_sujet.append("listAdherent", listAdhents);
			
		}

		List<String> listCommentaire = null;
		if(sujet.getListAdherent() != null){
			for (int i = 0; i < sujet.getListAdherent().size(); i++) {
				listCommentaire.add(sujet.getListCommentaire().get(i));
			}
			db_sujet.append("listCommentaire",listCommentaire);
		}
		
		if(this.getSujetObjectById(sujet.getId()) == null){
			if(this.myDB.insertToCollection(COLLECTION_NAME, db_sujet) != null){
				return sujet;
			}else{ 
				return null;
			}	
		}else{
			return null;
		}
	}

	@Override
	public Sujet supprimerSujet(Sujet sujet) {
		if(sujet!=null){
			BasicDBObject mySujet = this.getSujetObjectById(sujet.getId());
			if(mySujet != null){
				if(this.myDB.removeDocumentFromCollection(COLLECTION_NAME, mySujet) == true){
					return sujet;
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
	public Sujet modifierSujet(Sujet oldsujet, Sujet newsujet) {
		if(oldsujet != null){
			BasicDBObject oldObject = new BasicDBObject(); 
			oldObject.append("id",oldsujet.getId());
			oldObject.append("libelle",oldsujet.getLibelle());
			oldObject.append("description",oldsujet.getDescription());
			oldObject.append("prix",oldsujet.getPrix());
			oldObject.append("dateDepo",oldsujet.getDateDepo());
			oldObject.append("dateExtra",oldsujet.getDateExtra());
			oldObject.append("image",oldsujet.getImage());
			oldObject.append("note",oldsujet.getNote());
			oldObject.append("idUser",oldsujet.getPropietaire());
			oldObject.append("idCategorie",oldsujet.getCategorie());
			List<String> oldlistAdhents = null;
			if(oldsujet.getListAdherent() != null){
				for (int i = 0; i < oldsujet.getListAdherent().size(); i++) {
					oldlistAdhents.add(oldsujet.getListAdherent().get(i));
				}
				oldObject.append("listAdherent", oldlistAdhents);
			}

			List<String> oldlistCommentaire = null;
			if(oldsujet.getListAdherent() != null){
				for (int i = 0; i < oldsujet.getListAdherent().size(); i++) {
					oldlistCommentaire.add(oldsujet.getListCommentaire().get(i));
				}
				oldObject.append("listCommentaire",oldlistCommentaire);
				
			}
			
			/***************************************************************/
			
			BasicDBObject newObject = new BasicDBObject(); 
			newObject.append("id",newsujet.getId());
			newObject.append("libelle",newsujet.getLibelle());
			newObject.append("description",newsujet.getDescription());
			newObject.append("prix",newsujet.getPrix());
			newObject.append("dateDepo",newsujet.getDateDepo());
			newObject.append("dateExtra",newsujet.getDateExtra());
			newObject.append("image",newsujet.getImage());
			newObject.append("note",newsujet.getNote());
			newObject.append("idUser",newsujet.getPropietaire());
			newObject.append("idCategorie",newsujet.getCategorie());
			List<String> newlistAdhents = null;
			if( newsujet.getListAdherent() != null){
				for (int i = 0; i < newsujet.getListAdherent().size(); i++) {
					newlistAdhents.add(newsujet.getListAdherent().get(i));
				}
				newObject.append("listAdherent", newlistAdhents);
			}
			
			List<String> newlistCommentaire = null;
			if(newsujet.getListAdherent() != null){
				for (int i = 0; i < newsujet.getListAdherent().size(); i++) {
					newlistCommentaire.add(newsujet.getListCommentaire().get(i));
				}
				newObject.append("listCommentaire",newlistCommentaire);
			}
			
			/***************************************************************/
			
			if(this.myDB.updateCollection(COLLECTION_NAME, oldObject, newObject) != null){
				return newsujet;
			}else{ 
				return null;
			}
			
		}else{
			return null;
		}
	}

	@Override
	public Sujet getSujetById(String id) {
		List<Sujet> listSujets = this.getAllSujets();
		for (int i = 0; i < listSujets.size(); i++) {
			if(listSujets.get(i).getId().equalsIgnoreCase(id)){
				return listSujets.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Sujet> getAllSujets() {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		List<Sujet> lesSujets = new ArrayList<Sujet>();
		for (int i = 0; i < myDocumentsList.size(); i++) {
			lesSujets.add(
					new Sujet(
					myDocumentsList.get(i).get("id").toString(), 
					myDocumentsList.get(i).get("libelle").toString(),
					myDocumentsList.get(i).get("description").toString(),
					(Double)(myDocumentsList.get(i).get("prix")), 
					(Date)(myDocumentsList.get(i).get("dateDepo")),
					(Date)(myDocumentsList.get(i).get("dateExtra")),
					myDocumentsList.get(i).get("image").toString(),
					myDocumentsList.get(i).get("note").toString(),
					myDocumentsList.get(i).get("idUser").toString(),
					myDocumentsList.get(i).get("idCategorie").toString()
					)
				);
		}
		return lesSujets;
	}

	@Override
	public BasicDBObject getSujetObjectById(String id) {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		BasicDBObject sujetObject = null;
		for (int i = 0; i < myDocumentsList.size(); i++) {
			sujetObject = (BasicDBObject) myDocumentsList.get(i);
			if (sujetObject.get("id").toString().equalsIgnoreCase(id)) {
				return sujetObject;
			}
		}
		return null;
	}

	@Override
	public boolean supprimerToutLesSujet() {
		List<Sujet> listSujets = this.getAllSujets();
		if(listSujets != null){
			for (int i = 0; i < listSujets.size(); i++) {
				this.supprimerSujet(listSujets.get(i));
			}
			listSujets = this.getAllSujets();
			if(listSujets.size() == 0 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

}
