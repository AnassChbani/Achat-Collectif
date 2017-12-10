package com.achatCollectif.model;

import java.util.List;

public class Categorie {
	private String id;
	private String libelle;
	private List<Sujet> lesSujets;
	
	
	public Categorie(String id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String id, String libelle, List<Sujet> lesSujets) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.lesSujets = lesSujets;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + ", lesSujets="
				+ lesSujets + "]";
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
	public List<Sujet> getLesSujets() {
		return lesSujets;
	}
	public void setLesSujets(List<Sujet> lesSujets) {
		this.lesSujets = lesSujets;
	}

	
}
