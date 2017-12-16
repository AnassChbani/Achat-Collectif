package com.achatCollectif.model;

import java.io.Serializable;
import java.util.List;

public class Client extends User implements Serializable{

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client( String nom, String prenom, String cin, String email, String password) {
		super(nom, prenom, cin, email, password);
		this.estAdmin = false;
	}
	
	public Client(String id, String nom, String prenom, String cin, String email, String password) {
		super(id, nom, prenom, cin, email, password);
		this.estAdmin = false;
	}
	
}
