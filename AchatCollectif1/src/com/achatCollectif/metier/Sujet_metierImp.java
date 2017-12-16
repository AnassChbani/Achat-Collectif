package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public class Sujet_metierImp implements Sujet_metier {

	String HOST = "localhost";
	int PORT = 27017;
	String DATABASENAME = "AchatCollectif";
	
	private Sujet sujetMetier ;
	DBAccess dbAccess;
	
	public Sujet_metierImp(Sujet sujet){
		this.sujetMetier = sujet;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
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

	@Override
	public User ajouterAdherent(User user) {
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

	@Override
	public Commentaire ajouterCommentaire( Commentaire commentaire) {
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

	@Override
	public String getDuree() {
		Date dateCourante = new DateTime().toDate();
		Date dateEx = this.sujetMetier.getDateExtra();
		
		String duree = null;
		if(dateCourante != null && dateEx != null)
			duree = Helper.differenceBetxeenTwoDate(dateCourante, dateEx);
		return duree;
	}


	@Override
	public boolean estExpire() {
		Date dateCourante = new Date();
		Date dateExp = this.sujetMetier.getDateExtra();
		
		String duree = Helper.differenceBetxeenTwoDate(dateCourante, dateExp);
		if(duree.equalsIgnoreCase("expire")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean notifier(String messageNotification) {
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

	@Override
	public List<Client_metierImp> getListAdherents() {
		
		return null;
	}

	@Override
	public List<Commentaire> getListCommentaires() {
		return this.sujetMetier.getListCommentaire();
	}
	
	
	
}
