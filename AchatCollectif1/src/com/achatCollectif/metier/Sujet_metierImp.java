package com.achatCollectif.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.RequestWrapper;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.model.ParamQualifier;
import org.joda.time.DateTime;
import org.junit.runners.Parameterized.Parameters;

import com.achatCollectif.dao.DBAccess;
import com.achatCollectif.dao.DBAccessImp;
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
	
	@javax.ws.rs.PathParam("idSujet") String idSujet;
	
	@PostConstruct
	public void Sujet_metierImp(){
		Sujet sujet = null;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(idSujet!=null) {
			sujet = dbAccess.getSujetByIdFromDB(idSujet);
		}
		
		//if(sujet == null){
		//	sujet = dbAccess.ajouterSujet(ExempleObjetFront.getSujet());
		//}
		this.sujetMetier = sujet;
		this.dbAccess = new DBAccessImp(HOST, PORT, DATABASENAME);
		if(sujet.getId() == null){
			this.sujetMetier = this.dbAccess.ajouterSujet(sujet);
		}
		System.out.println("Hello : "+this.sujetMetier.toString());
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

	
	@POST
	@Path("/{idSujet}/ajouterAdherent")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet ajouterAdherent(User user) {	
		List<User> listAdherents = this.sujetMetier.getListAdherent();
		if(listAdherents == null){
			listAdherents = new ArrayList<User>();
		}
		listAdherents.add(user);
		
		Sujet nouveauSujet = this.sujetMetier;
		nouveauSujet.setListAdherent(listAdherents);
		System.out.println("nouveauSujet :"+nouveauSujet.toString());
		Sujet result = dbAccess.modifierSujet(this.sujetMetier, nouveauSujet);
		if(result != null){
			this.sujetMetier =  result; 
			System.out.println("Added : " +this.sujetMetier.getListAdherent().toString());
			return this.sujetMetier;
		}else{
			return null;
		}
	}
	
	
	
	//SUCCESSFUL
	@POST
	@Path("/{idSujet}/ajouterCommentaire")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Sujet ajouterCommentaire( Commentaire commentaire) { //
		
		System.out.println(commentaire.toString());
		Sujet nouveauSujet = this.sujetMetier;
		List<Commentaire> listCommentaires = nouveauSujet.getListCommentaire();
		if(listCommentaires == null){
			listCommentaires = new ArrayList<Commentaire>();
		}
		listCommentaires.add(commentaire);
		nouveauSujet.setListCommentaire(listCommentaires);
		Sujet nouveauS = dbAccess.modifierSujet(this.sujetMetier, nouveauSujet);
		
		if(nouveauS != null){
			this.sujetMetier = dbAccess.getSujetByIdFromDB(nouveauS.getId());
			return this.sujetMetier;
		}else{
            return null;
		}
	}

	//SUCCESSFUL
	@GET
	@Path("/{idSujet}/Duree")
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getDuree() {
		Date dateCourante = new DateTime().toDate();
		Date dateEx = this.sujetMetier.getDateExtra();
		
		String duree = null;
		if(dateCourante != null && dateEx != null)
			duree = Helper.differenceBetxeenTwoDate(dateCourante, dateEx);
		return duree;
	}

	//SUCCESSFUL
	@GET
	@Path("/{idSujet}/Expiration")
	@Produces(MediaType.TEXT_PLAIN)
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
	
	//SUCCESSFULL
	@Override
	public boolean notifier( String messageNotification) {	//@HeaderParam("messageNotification") 
		
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

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/{idSujet}/informations")
	public Sujet getSujetMetier() {
		System.out.println("getSujetMetier" + sujetMetier.toString());
		return sujetMetier;
	}

	public void setSujetMetier(Sujet sujetMetier) {
		this.sujetMetier = sujetMetier;
	}

	//SUCCESSFUL
	@GET
	@Path("/{idSujet}/lesAdherents")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Users getListAdherents() {
		return new Users(this.sujetMetier.getListAdherent());
	}

	//SUCCESSFUL
	@GET
	@Path("/{idSujet}/lesCommentaires")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Commentaires getListCommentaires() {
		
		Commentaires commentaires = new Commentaires(this.sujetMetier.getListCommentaire());
		return commentaires;
	}	
	
}
