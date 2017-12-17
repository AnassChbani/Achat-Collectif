package com.achatCollectif.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.JSONP;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class User implements Serializable {
	@XmlElement
	protected String id;
	@XmlElement
	protected String nom;
	@XmlElement
	protected String prenom;
	@XmlElement
	protected String password;
	@XmlElement
	protected String cin;
	@XmlElement
	protected String email;
	@XmlElement
    protected boolean estAdmin;
   // protected List<String> list_notification;
	
	
	public User () {
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
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", cin=" + cin + ", email=" + email + "]";
	}
	
	//public List<String> getList_notification() {
	//	return list_notification;
	//}
	//public void setList_notification(List<String> list_notification) {
	//	this.list_notification = list_notification;
	//}
	
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
