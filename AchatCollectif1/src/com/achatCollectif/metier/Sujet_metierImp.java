package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Commentaires;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;
import com.achatCollectif.model.Users;


@Path("/sujet")

public class Sujet_metierImp implements Sujet_metier {

	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	private Sujet sujetMetier ;
	DBAccess dbAccess;
	
	
	public Sujet_metierImp(){
		super();
		
	}	
	
	
	public Sujet_metierImp(Sujet sujet){
		this.sujetMetier = sujet;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(sujet.getId() == null){
			this.sujetMetier = this.dbAccess.ajouterSujet(sujet);
		}
	}
	
	
	@HeaderParam("sujet") Sujet sujet;
	@PostConstruct
	public void Sujet_metierImp(){
		if(sujet == null){
			sujet = ExempleObjetFront.getSujet();
		}
		this.sujetMetier = sujet;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(sujet.getId() == null){
			this.sujetMetier = this.dbAccess.ajouterSujet(sujet);
		}
	}
	
	@Override
	public double diminuerPrix() {
		double ancienPrix = this.sujetMetier.getPrix();
		double nouveauPrix = ancienPrix - this.sujetMetier.getTauxDiminutionParJour();
		if(nouveauPrix < this.sujetMetier.getPrixSeuil()) {
			nouveauPrix = this.sujetMetier.getPrixSeuil();
		}
		Sujet nouveauSujet = this.sujetMetier;
		nouveauSujet.setPrix(nouveauPrix);
		
		if(dbAccess.modifierSujet(this.sujetMetier, nouveauSujet) != null){
			return nouveauPrix;
		}else{
			return -1;
		}
	}

	//@POST
	//@Path("/ajouterAdherent")
	@Override
	public User ajouterAdherent(@FormParam("user") User user) {
		List<User> listAdherents = this.sujetMetier.getListAdherent();
		if(listAdherents == null){
			listAdherents = new ArrayList<User>();
		}
		listAdherents.add(user);
		
		Sujet nouveauSujet = this.sujetMetier;
		nouveauSujet.setListAdherent(listAdherents);
		
		Sujet result = dbAccess.modifierSujet(this.sujetMetier, nouveauSujet);
		if(result != null){
			return user;
		}else{
			return null;
		}
	}

	//@POST
	//@Path("/ajouterCommentaire")
	@Override
	public Commentaire ajouterCommentaire(@FormParam("commentaire") Commentaire commentaire) {
		Sujet nouveauSujet = this.sujetMetier;
		List<Commentaire> listCommentaires = nouveauSujet.getListCommentaire();
		if(listCommentaires == null){
			listCommentaires = new ArrayList<Commentaire>();
		}
		listCommentaires.add(commentaire);
		nouveauSujet.setListCommentaire(listCommentaires);
		if(dbAccess.modifierSujet(this.sujetMetier, nouveauSujet) != null){
			return commentaire;
		}else{
			return null;			
		}
	}

	@GET
	@Path("/getDuree")
	@Override
	public String getDuree() {
	/*	Date dateCourante = new DateTime().toDate();
		Date dateEx = this.sujetMetier.getDateExtra();
		
		String duree = null;
		if(dateCourante != null && dateEx != null)
			duree = Helper.differenceBetxeenTwoDate(dateCourante, dateEx);
		return duree;
		*/
		return "jhaha";
	}

	//@GET
	//@Path("/estExpire")
	@Override
	public boolean estExpire() {
		Date dateCourante = (new DateTime()).toDate();
		Date dateExp = this.sujetMetier.getDateExtra();
		
		String duree = Helper.differenceBetxeenTwoDate(dateCourante, dateExp);
		if(duree.equalsIgnoreCase("expire")){
			return true;
		}else{
			return false;
		}
	}

	//@POST
	//@Path("/notifier")
	@Override
	public boolean notifier(@FormParam("messageNotification") String messageNotification) {
		List<User> listAdherent = this.sujetMetier.getListAdherent();
		boolean sendingMail = false;
		
		if(listAdherent != null){
			for (int i = 0; i < listAdherent.size(); i++) {
				if(listAdherent.get(i) != null){
					if(listAdherent.get(i).getEmail() != null){
						System.out.println("Sending mail");
						sendingMail = Helper.sendEmail(listAdherent.get(i).getEmail(), "Notification Achat Collectif", messageNotification);
					}
				}
			}
		}
		return sendingMail;
	}

	public Sujet getSujetMetier() {
		return sujetMetier;
	}

	public void setSujetMetier(Sujet sujetMetier) {
		this.sujetMetier = sujetMetier;
	}

	//@GET
	//@Path("/ListAdherents")
	@Override
	public Users getListAdherents() {
		return new Users(this.sujetMetier.getListAdherent());
	}

	@GET
	@Path("/ListCommentaires")
	@Override
	public Commentaires getListCommentaires() {
		return new Commentaires(this.sujetMetier.getListCommentaire());
	}
	
	
	
}
