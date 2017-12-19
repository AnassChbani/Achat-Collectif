package com.achatCollectif.metier;


import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Sujet;

public interface Administrateur_metier extends Client_metier {
	public Categorie ajouterCategorie(String txtcategorie);
	public Sujet supprimerUnSujet(Sujet sujet);
	public Sujet modifierUnSujet(Sujet newSujet);
}
