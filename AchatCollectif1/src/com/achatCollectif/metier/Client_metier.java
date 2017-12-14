package com.achatCollectif.metier;

import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;

public interface Client_metier {
	public Sujet creerSujet(Sujet sujet);
	public Commentaire commenterSujet(Sujet sujet, Commentaire commentaire);
	public Sujet adhererAUnSujet(Sujet sujet);
	public Sujet supprimerSonSujet(Sujet sujet);
	public Sujet modifierSonSujet(Sujet oldSujet, Sujet newSujet);
	public Commentaire supprimerSonCommentaire(Sujet sujet, Commentaire commentaire);
	public boolean setNouvelleNotification();
}
