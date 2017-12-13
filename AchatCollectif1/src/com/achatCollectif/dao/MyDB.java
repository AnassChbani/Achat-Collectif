package com.achatCollectif.dao;

import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public interface MyDB {
	//R�cup�rer le nom de la database point� actuellement
	public DB getDatabase();

	//Pointer vers une nouvelle base de donn�es
	public DB setDatabase(DB myDatabase);
	
	//R�cup�r la list des bases de donn�es existantes
	public List<String> getListDBs();
	
	//R�cup�rer la liste des collections
	public Set<String> getCollections();
	
	//Creer et r�cup�rer une nouvelle collection
	public DBCollection createCollection(String collectionName);
	
	public void closeConnection();
	
	//Supprimer une collection
	public boolean dropCollection(String collectionName);
	
	//Cr�er un nouveau document
	public BasicDBObject createDocument();
	
	//Ins�rer un nouveau document dans une collection
	public BasicDBObject insertToCollection(String collectionName, BasicDBObject document);
	
	//Supprimer une collection
	public boolean removeCollection(String collectionName);
	
	//Supprimer un document
	public boolean removeDocumentFromCollection(String collectionName, BasicDBObject document);
	
	//Modifier une collection
	//Pas encore trait�e
	
	//Modifier une collection
	public BasicDBObject updateCollection(String collectionName, BasicDBObject olddocument, BasicDBObject newdocument);
	
	//R�cup�rer tous les document d'une collection 
	public List<DBObject> getdocumentsFromCollection(String collectionName);
}