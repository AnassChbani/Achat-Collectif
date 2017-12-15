package com.achatCollectif.metier;

import java.util.List;

import com.achatCollectif.dao.Categorie_dao;
import com.achatCollectif.dao.Categorie_daoImp;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;

public class Client_metierImp implements Client_metier {

	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	@Override
	public Sujet creerSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire commenterSujet(Sujet sujet, Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sujet adhererAUnSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sujet supprimerSonSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire supprimerSonCommentaire(Sujet sujet, Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setNouvelleNotification() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Categorie> getAllCategories() {
		Categorie_dao categorieDao = new Categorie_daoImp(HOST, PORT, DATABASENAME);
		return categorieDao.getAllCategories();
	}
	
}
