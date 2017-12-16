package com.achatCollectif.metier;

import java.util.List;

import com.achatCollectif.model.Client;
import com.achatCollectif.model.Commentaire;
import com.achatCollectif.model.Sujet;
import com.achatCollectif.model.User;

public interface Sujet_metier {
	public double diminuerPrix();
	public User ajouterAdherent(User user);
	public Commentaire ajouterCommentaire(Commentaire commentaire);
	public String getDuree();
	public boolean estExpire();
	public boolean notifier(String messageNotification);
	public List<Client_metierImp> getListAdherents();
	public List<Commentaire> getListCommentaires();
}
