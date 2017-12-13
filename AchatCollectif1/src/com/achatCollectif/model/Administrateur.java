package com.achatCollectif.model;

public class Administrateur extends User{

	public Administrateur() {
		super();
	}

	public Administrateur(String id, String nom, String prenom, String cin, String email, String password) {
		super(id, nom, prenom, cin, email, password);
		this.estAdmin = true;
	}	
	
	
}
