package com.achatCollectif.metier;

import java.util.List;

import com.achatCollectif.model.Categorie;
import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public interface Client_metier {
	public Sujet creerSujet(Sujet sujet);
	public Sujet commenterSujet(Sujet sujet, Commentaire commentaire);
	public Sujet adhererAUnSujet(Sujet sujet);
	public Sujet supprimerSonSujet(Sujet sujet);
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet);
	public Sujet supprimerSonCommentaire(Sujet sujet, Commentaire commentaire);
	public List<Categorie> getAllCategories();
	public boolean setNouvelleNotification();
	public User getInformations();
}
