package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Administrateur;

public interface Administrateur_dao {
	public void ajouterAdmin(Administrateur admin);
	public void supprimerAdmin(Administrateur admin);
	public void modifierAdmin(Administrateur oldAdmin, Administrateur newAdmin);
	public List<Administrateur> getAllAdmins();
	public Administrateur getAdministrateurByCin(String cin);
}
