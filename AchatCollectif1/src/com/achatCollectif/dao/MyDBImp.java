package com.achatCollectif.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.text.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MyDBImp implements MyDB {
	  MongoClient mongoConnextion = null;
	 DB myDatabase = null;
	 
    //Connexion � la base de donn�es
	public MyDBImp(String host, int port, String myDatabaseName){
		System.out.println("Demande de connexion au serveur");
		try {
			System.out.println("Connecting ..");
			mongoConnextion = new MongoClient(host, port); //27017
			myDatabase = mongoConnextion.getDB(myDatabaseName); 
		} catch (Exception e) {
			System.out.println("Un probl�me de connexion est survenu ");
			e.printStackTrace();
		}
	}
	
	//Connexion � la base de donn�es
	public MyDBImp(String host, int port){
		System.out.println("Demande de connexion au serveur");
		try {
			System.out.println("Connecting ..");
			mongoConnextion = new MongoClient(host, port); //27017
		} catch (Exception e) {
			System.out.println("Un probl�me de connexion est survenu");
		}
	}
	
	//R�cup�rer le nom de la database point� actuellement
	public DB getDatabase() {
		return myDatabase;
	}

	//Pointer vers une nouvelle base de donn�es
	public DB setDatabase(DB myDatabase) {
		this.myDatabase = myDatabase;
		return myDatabase;
	}
	
	//R�cup�r la list des bases de donn�es existantes
	public List<String> getListDBs(){
		//System.out.println("List databases");
		List<String> dbs = mongoConnextion.getDatabaseNames();
		return dbs;		
	}
	
	//R�cup�rer la liste des collections
	public Set<String> getCollections(){
		Set<String> tables = myDatabase.getCollectionNames();
		return tables;
	}
	
	//Creer et r�cup�rer une nouvelle collection
	public DBCollection createCollection(String collectionName){
		//System.out.println("Creating collection "+collectionName+" dans : "+myDatabase.toString());
		DBCollection col=null;
		try {
			if(!myDatabase.collectionExists(collectionName)){
				col = myDatabase.createCollection(collectionName, new BasicDBObject());
				System.out.println("Collection "+collectionName+" created");
			}else{
				System.out.println("Collection "+collectionName+" existe deja");
			}
		} catch (Exception e) {
			System.out.println("Erreur de cr�ation de collection "+e.getMessage());
			e.printStackTrace();
		}
		return col;
	}
	
	public void closeConnection(){
		mongoConnextion.close();
	}
	
	//Supprimer une collection
	public boolean dropCollection(String collectionName){
		//System.out.println("Suppression de collection "+collectionName);
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			collection.drop();
			return true; 
		} catch (Exception e) {
			System.out.println("Erreur de suppression");
			return false;
		}
	}
	
	//Cr�er un nouveau document
	public BasicDBObject createDocument(){
		//System.out.println("Creation de document");
		BasicDBObject  b = new BasicDBObject();
		System.out.println("Document created");
		return b;
	}
	
	//Ins�rer un nouveau document dans une collection
	public BasicDBObject insertToCollection(String collectionName, BasicDBObject document){
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			collection.insert(document);
			return document;
		} catch (Exception e) {
			//System.out.println("Erreur d'insertion");
			e.printStackTrace();
			return null;
		} 
	}
	
	//Supprimer une collection
	public boolean removeCollection(String collectionName){
		//System.out.println("Suppression de la collection :"+collectionName);
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			collection.drop();
			return true;
		} catch (Exception e) {
			System.out.println("Erreur d'insertion");
			return false;
		} 
	}
	
	//Supprimer un document
	public boolean removeDocumentFromCollection(String collectionName, BasicDBObject document){
		//System.out.println("Suppression du document :"+collectionName);
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			collection.remove(document);
			return true;
		} catch (Exception e) {
			System.out.println("Erreur d'insertion");
			return false;
		} 
	}
	//Modifier une collection
	
	//Modifier une collection
	public BasicDBObject updateCollection(String collectionName, BasicDBObject olddocument, BasicDBObject newdocument){
		//System.out.println("Insertion dans la collection");
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			collection.update(olddocument, newdocument);
			return newdocument;
		} catch (Exception e) {
			System.out.println("Erreur d'insertion");
			return null;
		} 
	}
	
	public List<DBObject> getdocumentsFromCollection(String collectionName){
		//System.out.println("R�cup�ration de document � partir de "+collectionName);
		List<DBObject> doc=null;
		try {
			DBCollection collection = myDatabase.getCollection(collectionName);
			doc= collection.find().toArray();
			return doc;
		} catch (Exception e) {
			System.out.println("Ereur de r�cup�ration de document");
		}
		return null;
	}
		
}
