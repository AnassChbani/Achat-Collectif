package com.achatCollectif.metier;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

@Path("/administrateur")
public class Administrateur_metierImp implements Administrateur_metier {

	@PathParam("idAdministrateur") String idAdministrateur;
	
	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	Administrateur administrateurMetier ;
	DBAccess dbAccess;
	
	
	
	public Administrateur_metierImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur_metierImp(Administrateur administrateur) {
		this.administrateurMetier = administrateur;
		dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(administrateur.getId() == null){
			administrateurMetier = dbAccess.ajouterAdministrateur(administrateur);
		}
	}
	
	@PostConstruct
	public void Administrateur_metierImp() {
		User user = null;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(idAdministrateur!=null) {
			user = dbAccess.getUserById(idAdministrateur);
		}
		if(user!=null){
			this.administrateurMetier = new Administrateur(user);
			if(user.getId() == null){
				this.administrateurMetier = this.dbAccess.ajouterAdministrateur(this.administrateurMetier);
			}
		}
	}
	
	@POST
	@Path("/{idAdministrateur}/ajouterCategorie")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		return dbAccess.ajouterCategorie(categorie);
	}
	
	
	@POST
	@Path("/{idAdministrateur}/supprimerSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet supprimerUnSujet(Sujet sujet) {
		return dbAccess.supprimerSujet(sujet);
	}

	@POST
	@Path("/{idAdministrateur}/modifierSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet modifierUnSujet(Sujet oldSujet, Sujet newSujet) {
		return dbAccess.modifierSujet(oldSujet, newSujet);
	}

	@POST
	@Path("/{idAdministrateur}/creerSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet creerSujet(Sujet sujet) {
		sujet.setIdUser(this.administrateurMetier.getId());
		return dbAccess.ajouterSujet(sujet);
	}

	@POST
	@Path("/{idAdministrateur}/commenterSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet commenterSujet(Sujet sujet, Commentaire commentaire) {
		Sujet_metier sujetMetier = new Sujet_metierImp(sujet);
		return sujetMetier.ajouterCommentaire(commentaire);
	}

	@POST
	@Path("/{idAdministrateur}/adhererSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet adhererAUnSujet(Sujet sujet) {
		Sujet_metier sujetMetier = new Sujet_metierImp(sujet);
		return sujetMetier.ajouterAdherent(this.administrateurMetier);
	}

	@POST
	@Path("/{idAdministrateur}/supprimerSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet supprimerSonSujet(Sujet sujet) {
		return supprimerUnSujet(sujet);
	}
	
	
	@POST
	@Path("/{idAdministrateur}/modifierSujet")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet) {
		if(oldSujet.getPropietaire().equals(this.administrateurMetier.getId())){
			return dbAccess.modifierSujet(oldSujet, newSujet);
		}
		return null;
	}

	
	@POST
	@Path("/{idAdministrateur}/supprimerCommentaire")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet supprimerSonCommentaire(Sujet sujet, Commentaire commentaire) {
		List<Commentaire> listCommentaires = sujet.getListCommentaire();
		if(listCommentaires == null) return sujet;
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

	@POST
	@Path("/{idAdministrateur}/lesCategories")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
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

	@Override
	public User getInformations() {
		return (User)this.administrateurMetier;
	}

}
