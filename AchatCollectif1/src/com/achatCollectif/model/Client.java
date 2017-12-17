package com.achatCollectif.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Client extends User implements Serializable{

	public Client() {
		super();
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
