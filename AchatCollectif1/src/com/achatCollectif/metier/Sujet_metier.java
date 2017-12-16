package com.achatCollectif.metier;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Commentaires;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;
import com.achatCollectif.model.Users;

public interface Sujet_metier {
	
	public double diminuerPrix();
	public User ajouterAdherent( User user);
	public Commentaire ajouterCommentaire( Commentaire commentaire);
	public String getDuree();
	public boolean estExpire();
	public boolean notifier(String messageNotification);
	public Users getListAdherents();
	public Commentaires getListCommentaires();
}
