package com.achatCollectif.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class Administrateur extends User implements Serializable{

	public Administrateur() {
		super();
	}

	public Administrateur(String id, String nom, String prenom, String cin, String email, String password) {
		super(id, nom, prenom, cin, email, password);
		this.estAdmin = true;
	}	
	
	public Administrateur( String nom, String prenom, String cin, String email, String password) {
		super(nom, prenom, cin, email, password);
		this.estAdmin = true;
	}	
	
	
}
