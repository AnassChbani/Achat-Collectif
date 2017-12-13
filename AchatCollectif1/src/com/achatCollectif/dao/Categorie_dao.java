package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Categorie;
import com.mongodb.BasicDBObject;

public interface Categorie_dao {
	public Categorie ajouterCategorie(Categorie categorie);
	public Categorie supprimerCategorie(Categorie categorie);
	public Categorie modifierCategorie(Categorie oldCategorie, Categorie newCategorie);
	public Categorie getCategorieById(String id);
	public BasicDBObject getCategorieObjectById(String id);
	public List<Categorie> getAllCategories();
	public boolean supprimerToutLesCategories();
}
