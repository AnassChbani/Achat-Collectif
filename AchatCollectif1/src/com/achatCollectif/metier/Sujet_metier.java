package com.achatCollectif.metier;

import java.util.List;

import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Commentaires;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.Sujets;
import com.achatCollectif.model.User;
import com.achatCollectif.model.Users;

public interface Sujet_metier {
	
	public double diminuerPrix();
	public Sujet ajouterAdherent( User user );//Working
	public Sujet ajouterCommentaire( Commentaire commentaire ); //
	public String getDuree(); //Working
	public boolean estExpire(); //Working
	public boolean notifier( String messageNotification);	//Working
	public Users getListAdherents(); //Working
	public Commentaires getListCommentaires(); //Working
}
