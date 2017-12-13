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
	private String idUser;
	private String idCategorie;
	private List<String> listAdherent;
	private List<String> listCommentaire;
	
	
	
	@Override
	public String toString() {
		return "Sujet [id=" + id + ", libelle=" + libelle + ", description="
				+ description + ", prix=" + prix + ", dateDepo=" + dateDepo
				+ ", dateExtra=" + dateExtra + ", image=" + image + ", note="
				+ note + ", propietaire=" + idUser + ", categorie="
				+ idCategorie + ", listAdherent=" + listAdherent
				+ ", listCommentaire=" + listCommentaire + "]";
	}
	public Sujet(String id, String libelle, String description, double prix,
			Date dateDepo, Date dateExtra, String image, String note,
			String idUser, String idCategorie) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.dateDepo = dateDepo;
		this.dateExtra = dateExtra;
		this.image = image;
		this.note = note;
		this.idUser = idUser;
		this.idCategorie = idCategorie;
	}
	public Sujet(String id, String libelle, String description, double prix,
			Date dateDepo, Date dateExtra, String image, String note,
			String idUser, String idCategorie, List<String> listAdherent,
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
		this.idUser = idUser;
		this.idCategorie = idCategorie;
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
	public String getPropietaire() {
		return idUser;
	}
	public void setPropietaire(String idUser) {
		this.idUser = idUser;
	}
	public String getCategorie() {
		return idCategorie;
	}
	public void setCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	public List<String> getListAdherent() {
		return listAdherent;
	}
	public void setListAdherent(List<String> listAdherent) {
		this.listAdherent = listAdherent;
	}
	public List<String> getListCommentaire() {
		return listCommentaire;
	}
	public void setListCommentaire(List<String> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}
	
	
}
