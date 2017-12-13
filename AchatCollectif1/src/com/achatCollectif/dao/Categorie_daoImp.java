package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.RemoteEndpoint.Basic;

import com.achatCollectif.model.Categorie;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Categorie_daoImp extends MyCollection implements Categorie_dao {

	String COLLECTION_NAME="Categorie";
	
	
	public Categorie_daoImp(String host, int port, String dataBaseName) {
		super(host, port, dataBaseName);
	}

	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		BasicDBObject db_categorie = new BasicDBObject(); 
		db_categorie.append("id",categorie.getId());
		db_categorie.append("libelle",categorie.getLibelle());
		if(this.getCategorieObjectById(categorie.getId()) == null){
			if(this.myDB.insertToCollection(COLLECTION_NAME, db_categorie) != null){
				return categorie;
			}else{ 
				return null;
			}	
		}else{
			return null;
		}	
	}

	@Override
	public Categorie supprimerCategorie(Categorie categorie) {
		BasicDBObject myCategorie = this.getCategorieObjectById(categorie.getId());
		if(myCategorie != null){
			if(this.myDB.removeDocumentFromCollection(COLLECTION_NAME, myCategorie) == true){
				return categorie;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Categorie modifierCategorie(Categorie oldCategorie, Categorie newCategorie) {
		if(oldCategorie != null){
			BasicDBObject oldObject = new BasicDBObject();
			oldObject.append("id", oldCategorie.getId());
			oldObject.append("libelle", oldCategorie.getLibelle());
			
			BasicDBObject newObject = new BasicDBObject();
			newObject.append("id", newCategorie.getId());
			newObject.append("libelle", newCategorie.getLibelle());
			
			if(this.myDB.updateCollection(COLLECTION_NAME, oldObject, newObject) != null){
				return newCategorie;
			}else{ 
				return null;
			}
			
		}else{
			return null;
		}
	}

	@Override
	public Categorie getCategorieById(String id) {
		List<Categorie> myCategoriesList = this.getAllCategories();
		//System.out.println("Recherche dans : "+myCategoriesList.toString());
		for (int i = 0; i < myCategoriesList.size(); i++) {
			if (myCategoriesList.get(i).getId().equalsIgnoreCase(id)) {
				return myCategoriesList.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<DBObject> myDocumentsList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		if(myDocumentsList != null){
			List<Categorie> myCategoriesList = new ArrayList<Categorie>();
			try {
				for (int i = 0; i < myDocumentsList.size(); i++) {
					myCategoriesList.add(new Categorie(myDocumentsList.get(i).get("_id").toString(),
							myDocumentsList.get(i).get("libelle").toString()
						)
					);
				}
				return myCategoriesList;
			} catch (Exception e) {
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public BasicDBObject getCategorieObjectById(String id) {
		List<DBObject> myCategoriesList = this.myDB.getdocumentsFromCollection(COLLECTION_NAME);
		BasicDBObject categoieObject = null;
		for (int i = 0; i < myCategoriesList.size(); i++) {
			categoieObject = (BasicDBObject) myCategoriesList.get(i);
			if (categoieObject.get("id").toString().equalsIgnoreCase(id)) {
				return categoieObject;
			}
		}
		return null;
	}

	@Override
	public boolean supprimerToutLesCategories() {
		List<Categorie> listCategories = this.getAllCategories();
		if(listCategories != null){
			for (int i = 0; i < listCategories.size(); i++) {
				this.supprimerCategorie(listCategories.get(i));
			}
			listCategories = this.getAllCategories();
			if(listCategories.size() == 0 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

}
