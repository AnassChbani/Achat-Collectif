package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;


@Path("/client")
public class Client_metierImp implements Client_metier {

	@javax.ws.rs.PathParam("idClient") String idClient;
	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	Client clientMetier;
	DBAccess dbAccess;
	
	public Client_metierImp(){
		super();
	}
	
	public Client_metierImp(Client client){
		this.clientMetier = client;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(client.getId() == null){
			this.clientMetier = this.dbAccess.ajouterClient(client);
		}
	}
	
	@PostConstruct
	public void Client_metierImp(){
		User user = null;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(idClient!=null) {
			user = dbAccess.getUserById(idClient);
		}
		if(user!=null){
			this.clientMetier = new Client(user);
			if(user.getId() == null){
				this.clientMetier = this.dbAccess.ajouterClient(this.clientMetier);
			}
		}
	}
	
	//Not tested but seems working
	@POST
	@Path("/{idClient}/creerSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet creerSujet(Sujet sujet) {
		sujet.setIdUser(this.clientMetier.getId());
	    return dbAccess.ajouterSujet(sujet);
	}

	//Not tested but seems working
	@POST
	@Path("/{idClient}/{idSujet}/{txtCommentaire}")
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet commenterSujet(@PathParam("idSujet")  String idSujet, @PathParam("txtCommentaire") String txtCommentaire) {
		Sujet sujet = dbAccess.getSujetByIdFromDB(idSujet);
		Commentaire commentaire = new Commentaire(txtCommentaire, this.clientMetier);
		Sujet_metier sujetMetier = new Sujet_metierImp(sujet);
		return sujetMetier.ajouterCommentaire(commentaire);
	}

	//Not tested but seems working
	@POST
	@Path("/{idClient}/adhererSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet adhererAUnSujet(Sujet sujet) {
		Sujet_metier sujetMetier = new Sujet_metierImp(sujet);
		return sujetMetier.ajouterAdherent(this.clientMetier);
	}

	//Not tested but seems working
	@POST
	@Path("/{idClient}/supprimerSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet supprimerSonSujet(Sujet sujet) {
		Sujet sujetDb = dbAccess.getSujetByIdFromDB(sujet.getId());
		if(dbAccess.getProprietaire(sujetDb).getCin().equalsIgnoreCase(this.clientMetier.getCin())){
			return dbAccess.supprimerSujet(sujetDb);
		}
		return null;
	}

	//Not tested but seems working
	@POST
	@Path("/{idClient}/modierSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet modifierSonSujet(Sujet sujet) {
		if(sujet.getPropietaire().equals(this.clientMetier.getId())){
			return dbAccess.modifierSujet(sujet, sujet);
		}
		return null;
	}

	//Not tested but seems working
	@POST
	@Path("/{idClient}/supprimerCommentaire")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet supprimerSonCommentaire(Sujet sujetDB, Commentaire commentaire) {
		List<Commentaire> listCommentaires = sujetDB.getListCommentaire();
		if(listCommentaires == null) return sujetDB;
		for (int i = 0; i < listCommentaires.size(); i++) {
			if(listCommentaires.get(i).getProprietaire().getCin().equals(this.clientMetier.getCin())){
				Sujet newSujet = sujetDB;
				newSujet.getListCommentaire().remove(i);
				return dbAccess.modifierSujet(sujetDB, newSujet);
			}
		}
		return null;
	}

	@Override
	public boolean setNouvelleNotification() {
		return true;
	}
	
	@GET
	@Path("/{idClient}/lesCategories")
	@Produces(MediaType.APPLICATION_XML)
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

	@GET
	@Path("/{idClient}/informations")
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public User getInformations() {
		return (User)this.clientMetier;
	}
	
}
