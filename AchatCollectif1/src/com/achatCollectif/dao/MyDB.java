package com.achatCollectif.dao;

import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public interface MyDB {
	//Récupérer le nom de la database pointé actuellement
	public DB getDatabase();

	//Pointer vers une nouvelle base de données
	public DB setDatabase(DB myDatabase);
	
	//Récupér la list des bases de données existantes
	public List<String> getListDBs();
	
	//Récupérer la liste des collections
	public Set<String> getCollections();
	
	//Creer et récupérer une nouvelle collection
	public DBCollection createCollection(String collectionName);
	
	public void closeConnection();
	
	//Supprimer une collection
	public boolean dropCollection(String collectionName);
	
	//Créer un nouveau document
	public BasicDBObject createDocument();
	
	//Insérer un nouveau document dans une collection
	public BasicDBObject insertToCollection(String collectionName, BasicDBObject document);
	
	//Supprimer une collection
	public boolean removeCollection(String collectionName);
	
	//Supprimer un document
	public boolean removeDocumentFromCollection(String collectionName, BasicDBObject document);
	
	//Modifier une collection
	//Pas encore traitée
	
	//Modifier une collection
	public BasicDBObject updateCollection(String collectionName, BasicDBObject olddocument, BasicDBObject newdocument);
	
	//Récupérer tous les document d'une collection 
	public List<DBObject> getdocumentsFromCollection(String collectionName);
}