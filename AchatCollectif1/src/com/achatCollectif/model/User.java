package com.achatCollectif.model;

import java.util.List;

public class User {
	protected String id;
	protected String nom;
	protected String prenom;
	protected String password;
	protected String cin;
	protected String email;
    protected boolean estAdmin;
    protected List<String> list_notification;
	
	
	public User () {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String nom, String prenom, String cin, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = password;
	}
	
	public User(String nom, String prenom, String cin, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = password;
	}
	public User(String id, String nom, String prenom, String cin, String email, String password, boolean estAdmin) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.estAdmin = estAdmin;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return estAdmin;
	}
	public void setIsAdmin(boolean estAdmin) {
		this.estAdmin = estAdmin;
	}
	
	
	
}
