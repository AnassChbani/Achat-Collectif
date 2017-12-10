package com.achatCollectif.model;

import java.util.List;

public class Client extends Visiteur{
	private String id;
	private String nom;
	private String prenom;
	private String cin;
	private String email;
	private List<String> list_notification;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String id, String nom, String prenom, String cin, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", cin=" + cin + ", email=" + email + "]";
	}
	
	
	
	public List<String> getList_notification() {
		return list_notification;
	}
	public void setList_notification(List<String> list_notification) {
		this.list_notification = list_notification;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
