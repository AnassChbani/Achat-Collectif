package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Client;

public interface Client_dao {
	public void ajouterClient(Client client);
	public void supprimerClient(Client client);
	public void modifierClient(Client oldclient, Client newclient);
	public Client getClientByCin(String cin);
	public List<Client> getAllClients();
}
