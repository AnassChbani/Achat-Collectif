package com.achatCollectif.metier;

import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.User;

public interface Sujet_metier {
	public double diminuerPrix();
	public User ajouterAdherent(User user);
	public Commentaire ajouterCommentaire();
	public String getDuree();
	public boolean estExpire();
	public boolean notifier();
}
