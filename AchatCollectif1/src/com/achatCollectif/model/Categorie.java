package com.achatCollectif.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Categorie implements Serializable{
	private String id;
	private String libelle;
	
	
	public Categorie(String id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Categorie( String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Categorie() {
		super();
	}
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle;
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
		
}
