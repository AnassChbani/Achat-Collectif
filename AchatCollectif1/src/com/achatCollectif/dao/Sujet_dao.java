package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Sujet;
import com.mongodb.BasicDBObject;

public interface Sujet_dao {
	public Sujet ajouterSujet(Sujet sujet);
	public Sujet supprimerSujet(Sujet sujet);
	public Sujet modifierSujet(Sujet oldSujet, Sujet newSujet);
	public Sujet getSujetById(String id);
	public BasicDBObject getSujetObjectById(String id);
	public List<Sujet> getAllSujets();
	public boolean supprimerToutLesSujet();
}