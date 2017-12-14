package com.achatCollectif.model;

import java.util.List;

public class Categorie {
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
