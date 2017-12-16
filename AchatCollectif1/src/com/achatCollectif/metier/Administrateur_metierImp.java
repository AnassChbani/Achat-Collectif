package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.List;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public class Administrateur_metierImp implements Administrateur_metier {

	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	Administrateur administrateurMetier ;
	DBAccess dbAccess;
	
	public Administrateur_metierImp(Administrateur administrateur) {
		this.administrateurMetier = administrateur;
		dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
	}
	
	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		return dbAccess.ajouterCategorie(categorie);
	}
	
	@Override
	public Sujet supprimerUnSujet(Sujet sujet) {
		return dbAccess.supprimerSujet(sujet);
	}

	@Override
	public Sujet modifierUnSujet(Sujet oldSujet, Sujet newSujet) {
		return dbAccess.modifierSujet(oldSujet, newSujet);
	}

	@Override
	public Sujet creerSujet(Sujet sujet) {
		return dbAccess.ajouterSujet(sujet);
	}

	@Override
	public Sujet commenterSujet(Sujet sujet, Commentaire commentaire) {
		Sujet oldSujet = dbAccess.getSujetByIdFromDB(sujet.getId());
		Sujet newSujet = oldSujet;
		List<Commentaire> listComments = newSujet.getListCommentaire();
		if(listComments == null){
			listComments = new ArrayList<Commentaire>();
		}
		listComments.add(commentaire);
		newSujet.setListCommentaire(listComments);
		return dbAccess.modifierSujet(oldSujet, newSujet);
	}

	@Override
	public Sujet adhererAUnSujet(Sujet sujet) {
		Sujet oldSujet = dbAccess.getSujetByIdFromDB(sujet.getId());
		Sujet newSujet = oldSujet;
		List<User> listAdherents = oldSujet.getListAdherent();
		if(listAdherents == null){
			listAdherents = new ArrayList<User>();
		}
		listAdherents.add(this.administrateurMetier);
		newSujet.setListAdherent(listAdherents);
		return dbAccess.modifierSujet(oldSujet, newSujet);
	}

	@Override
	public Sujet supprimerSonSujet(Sujet sujet) {
		return supprimerUnSujet(sujet);
	}

	@Override
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet) {
		if(oldSujet.getPropietaire().equals(this.administrateurMetier.getId())){
			return dbAccess.modifierSujet(oldSujet, newSujet);
		}
		return null;
	}

	@Override
	public Sujet supprimerSonCommentaire(Sujet sujet, Commentaire commentaire) {
		List<Commentaire> listCommentaires = sujet.getListCommentaire();
		for (int i = 0; i < listCommentaires.size(); i++) {
			if(listCommentaires.get(i).equals(commentaire.getProprietaire())){
				if(listCommentaires.get(i).getProprietaire().equals(this.administrateurMetier.getId())){
					Sujet newSujet = sujet;
					newSujet.getListCommentaire().remove(i);
					return dbAccess.modifierSujet(sujet, newSujet);
				}
			}
		}
		return null;
	}

	@Override
	public boolean setNouvelleNotification() {
		return true;
	}

	@Override
	public List<Categorie> getAllCategories() {
		return dbAccess.getAllCategories();
	}

	public Administrateur getAdministrateurMetier() {
		return administrateurMetier;
	}

	public void setAdministrateurMetier(Administrateur administrateurMetier) {
		this.administrateurMetier = administrateurMetier;
	}

	
	

}
