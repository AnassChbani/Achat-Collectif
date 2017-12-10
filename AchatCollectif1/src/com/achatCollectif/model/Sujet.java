package com.achatCollectif.model;

import java.util.Date;
import java.util.List;

public class Sujet {
	private String id;
	private String libelle;
	private String description;
	private double prix;
	private Date dateDepo;
	private Date dateExtra;
	private String image;
	private String note;
	private Client propietaire;
	private Categorie categorie;
	private List<Client> listAdherent;
	private List<String> listCommentaire;
	
	
	
	@Override
	public String toString() {
		return "Sujet [id=" + id + ", libelle=" + libelle + ", description="
				+ description + ", prix=" + prix + ", dateDepo=" + dateDepo
				+ ", dateExtra=" + dateExtra + ", image=" + image + ", note="
				+ note + ", propietaire=" + propietaire + ", categorie="
				+ categorie + ", listAdherent=" + listAdherent
				+ ", listCommentaire=" + listCommentaire + "]";
	}
	public Sujet(String id, String libelle, String description, double prix,
			Date dateDepo, Date dateExtra, String image, String note,
			Client propietaire, Categorie categorie) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.dateDepo = dateDepo;
		this.dateExtra = dateExtra;
		this.image = image;
		this.note = note;
		this.propietaire = propietaire;
		this.categorie = categorie;
	}
	public Sujet(String id, String libelle, String description, double prix,
			Date dateDepo, Date dateExtra, String image, String note,
			Client propietaire, Categorie categorie, List<Client> listAdherent,
			List<String> listCommentaire) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.dateDepo = dateDepo;
		this.dateExtra = dateExtra;
		this.image = image;
		this.note = note;
		this.propietaire = propietaire;
		this.categorie = categorie;
		this.listAdherent = listAdherent;
		this.listCommentaire = listCommentaire;
	}
	public Sujet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDateDepo() {
		return dateDepo;
	}
	public void setDateDepo(Date dateDepo) {
		this.dateDepo = dateDepo;
	}
	public Date getDateExtra() {
		return dateExtra;
	}
	public void setDateExtra(Date dateExtra) {
		this.dateExtra = dateExtra;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Client getPropietaire() {
		return propietaire;
	}
	public void setPropietaire(Client propietaire) {
		this.propietaire = propietaire;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Client> getListAdherent() {
		return listAdherent;
	}
	public void setListAdherent(List<Client> listAdherent) {
		this.listAdherent = listAdherent;
	}
	public List<String> getListCommentaire() {
		return listCommentaire;
	}
	public void setListCommentaire(List<String> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}
	
	
}
