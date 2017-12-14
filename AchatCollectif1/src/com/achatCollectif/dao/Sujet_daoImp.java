package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.RemoteEndpoint.Basic;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
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
		BasicDBObject db_sujet = createDBObjectFromSujet(sujet); 
		User_dao userdao = new User_daoImp(host, port, dataBaseName);
		if(this.getSujetObject(sujet) == null){
			BasicDBObject objectInserted = this.myDB.insertToCollection(COLLECTION_NAME, db_sujet);
			if( objectInserted != null){
				return createSujetFromDbObject(objectInserted, userdao);
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
			BasicDBObject mySujet = this.getSujetObject(sujet);
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
	    BasicDBObject oldObject = createDBObjectFromSujet(oldsujet);
	    BasicDBObject newObject = createDBObjectFromSujet(newsujet);
	    if(oldObject != null && newObject!=null){
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
	public List<Sujet> getAllSujets() {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		List<Sujet> lesSujets = new ArrayList<Sujet>();
		User_dao userdao = new User_daoImp(this.host, this.port, this.dataBaseName);
		for (int i = 0; i < myDocumentsList.size(); i++) {
			lesSujets.add( 
					createSujetFromDbObject( (BasicDBObject)myDocumentsList.get(i), userdao ));
		}
		return lesSujets;
	}

	@Override
	public BasicDBObject getSujetObject(Sujet sujet) {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		System.out.println("myDocumentsList : "+myDocumentsList);
		System.out.println("Sujet : "+sujet.getId());
		BasicDBObject sujetObject = null;
		for (int i = 0; i < myDocumentsList.size(); i++) {
			sujetObject = (BasicDBObject) myDocumentsList.get(i);
			if (sujetObject.get("_id").toString().equalsIgnoreCase(sujet.getId())) {
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

	public Sujet createSujetFromDbObject(BasicDBObject dbObject, User_dao userdao){
		String id = dbObject.get("_id").toString();
		String libelle = dbObject.get("libelle").toString();
		String description = dbObject.get("description").toString();
		double prix = (Double)(dbObject.get("prix"));
		Date dateDepo = (Date)(dbObject.get("dateDepo"));
		Date dateExtra = (Date)(dbObject.get("dateExtra"));
		String image = dbObject.get("image").toString();
		String note = dbObject.get("note").toString();
		double tauxDiminutionParJour = dbObject.getDouble("tauxDiminutionParJour");
		String idUser = dbObject.get("idUser").toString();
		String idCategorie = dbObject.get("idCategorie").toString();
		List<BasicDBObject> listAdherentsObject = (ArrayList<BasicDBObject>)dbObject.get("listAdherent");
		List<BasicDBObject> listCommentairesObject = (ArrayList<BasicDBObject>)dbObject.get("listCommentaire");
		
		List<User> listAdherents = new ArrayList<User>() ;
		User adherent = null;
		if(listAdherentsObject != null){
			for (int i = 0; i < listAdherentsObject.size(); i++) {
				adherent = userdao.getUserById(listAdherentsObject.get(i).getString("idAdherent"));
				if(adherent != null ){
					listAdherents.add(adherent);
				}
			}
		}
		
		List<Commentaire> listCommentaires = new ArrayList<Commentaire>() ;
		String textCommentaire;
		User commentOwner = null;
		
		if(listCommentairesObject != null){
			for (int i = 0; i < listCommentairesObject.size(); i++) {
				commentOwner = userdao.getUserById(listCommentairesObject.get(i).getString("idproprietaire"));
				textCommentaire = listCommentairesObject.get(i).getString("textCommentaire");
				listCommentaires.add(new Commentaire(textCommentaire, commentOwner));
			}
		}
		
		Sujet monSujet = new Sujet(id, libelle, description, prix, dateDepo, dateExtra, image, note, tauxDiminutionParJour, idUser, idCategorie);		
		if(listAdherents != null){ ;
			monSujet.setListAdherent(listAdherents);
		}
		
		if(listCommentaires != null){
			monSujet.setListCommentaire(listCommentaires);
		}
		return monSujet;
	}
	
	public BasicDBObject createDBObjectFromSujet(Sujet sujet){
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.append("libelle",sujet.getLibelle());
		dbObject.append("description",sujet.getDescription());
		dbObject.append("prix",sujet.getPrix());
		dbObject.append("dateDepo",sujet.getDateDepo());
		dbObject.append("dateExtra",sujet.getDateExtra());
		dbObject.append("image",sujet.getImage());
		dbObject.append("note",sujet.getNote());
		dbObject.append("idUser",sujet.getPropietaire());
		dbObject.append("idCategorie",sujet.getCategorie());
		
		ArrayList<DBObject> listAdhents = new ArrayList<DBObject>();
		BasicDBObject adherentDBObject = new BasicDBObject();
		if( sujet.getListAdherent() != null){
			for (int i = 0; i < sujet.getListAdherent().size(); i++) {
				adherentDBObject.append("idAdherent", sujet.getListAdherent().get(i).getId());
				listAdhents.add(adherentDBObject);
			}
			dbObject.put("listAdherent", listAdhents);
		}
		
		List<DBObject> listCommentaires = new ArrayList<DBObject>();
		BasicDBObject unCommentaire = new BasicDBObject();
		if(sujet.getListAdherent() != null){
			for (int i = 0; i < sujet.getListAdherent().size(); i++) {
				unCommentaire.append("textCommentaire", sujet.getListCommentaire().get(i).getTextCommentaire());
				unCommentaire.append("idproprietaire", sujet.getListCommentaire().get(i).getProprietaire().getId());
				listCommentaires.add(unCommentaire);
			}
			dbObject.put("listCommentaire",listCommentaires);
		}
		return dbObject;
	}

}
