package com.achatCollectif.metier;

public interface Sujet_metier {
	public void diminuerPrix();
	public void ajouterAdherent();
	public void ajouterCommentaire();
	public String getDuree();
	public void diminuerDuree();
	public boolean estExpire();
	public void notifier();
}
