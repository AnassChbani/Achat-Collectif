package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public class Client_metierImp implements Client_metier {

	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	Client clientMetier;
	DBAccess dbAccess;
	
	public Client_metierImp(Client client){
		clientMetier = client;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(client.getId() == null){
			clientMetier = dbAccess.ajouterClient(client);
		}
	}
	
	
	@Override
	public Sujet creerSujet(Sujet sujet) {
		System.out.println("setIdUser "+this.clientMetier.getId());
		sujet.setIdUser(this.clientMetier.getId());
	     return dbAccess.ajouterSujet(sujet);
	}

	@Override
	public Sujet commenterSujet(Sujet sujet, Commentaire commentaire) {
		Sujet oldSujet = dbAccess.getSujetByIdFromDB(sujet.getId());
		Sujet newSujet = oldSujet;
		List<Commentaire> listComments = oldSujet.getListCommentaire();
		if(listComments == null){
			listComments = new ArrayList<Commentaire>();
		}
		commentaire.setProprietaire(this.clientMetier);
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
		listAdherents.add(this.clientMetier);
		newSujet.setListAdherent(listAdherents);
		return dbAccess.modifierSujet(oldSujet, newSujet);
	}

	@Override
	public Sujet supprimerSonSujet(Sujet sujet) {
		Sujet sujetDb = dbAccess.getSujetByIdFromDB(sujet.getId());
		List<User> listUsers = dbAccess.getAllUsers();
		
		System.out.println("Suppression de son sujet "+ listUsers.size());
		if(dbAccess.getProprietaire(sujetDb).getCin().equalsIgnoreCase(this.clientMetier.getCin())){
			return dbAccess.supprimerSujet(sujetDb);
		}
		return null;
	}

	@Override
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet) {
		if(oldSujet.getPropietaire().equals(this.clientMetier.getId())){
			return dbAccess.modifierSujet(oldSujet, newSujet);
		}
		return null;
	}

	@Override
	public Sujet supprimerSonCommentaire(Sujet sujetDB, Commentaire commentaire) {
		//Sujet sujetDB = dbAccess.getSujetByIdFromDB(sujet.getId());
		System.out.println("SujetDb ! "+ sujetDB.toString());
		List<Commentaire> listCommentaires = sujetDB.getListCommentaire();
		if(listCommentaires == null) return sujetDB;
		for (int i = 0; i < listCommentaires.size(); i++) {
			if(listCommentaires.get(i).getProprietaire().getCin().equals(this.clientMetier.getCin())){
				Sujet newSujet = sujetDB;
				newSujet.getListCommentaire().remove(i);
				System.out.println("Removing this fucking comment");
				return dbAccess.modifierSujet(sujetDB, newSujet);
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

	public Client getClientMetier() {
		return clientMetier;
	}

	public void setClientMetier(Client clientMetier) {
		this.clientMetier = clientMetier;
	}
	
}
