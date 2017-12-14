package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Administrateur;
import com.achatCollectif.model.Client;
import com.mongodb.BasicDBObject;

public interface Administrateur_dao {
	public Administrateur ajouterAdministrateur(Administrateur admin);
	public Administrateur supprimerAdministrateur(Administrateur admin);
	public Administrateur modifierAdministrateur(Administrateur oldAdmin, Administrateur newAdmin);
	public Administrateur getAdministrateurByCin(String cin);
	public List<Administrateur> getAllAdministrateurs();
	public BasicDBObject getAdministrateurObject(Administrateur administrateur);
	public boolean supprimerToutLesAdministrateurs();
}
