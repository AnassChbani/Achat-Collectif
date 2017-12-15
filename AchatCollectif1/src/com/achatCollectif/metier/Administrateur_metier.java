package com.achatCollectif.metier;

import java.util.List;

import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Sujet;

public interface Administrateur_metier extends Client_metier {
	public Categorie ajouterCategorie(Categorie categorie);
	public Sujet supprimerUnSujet(Sujet sujet);
	public Sujet modifierUnSujet(Sujet oldSujet, Sujet newSujet);
}
