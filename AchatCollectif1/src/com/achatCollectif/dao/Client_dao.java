package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.Client;
import com.mongodb.BasicDBObject;

public interface Client_dao {
	public Client ajouterClient(Client client);
	public Client supprimerClient(Client client);
	public Client modifierClient(Client oldclient, Client newclient);
	public Client getClientByCin(String cin);
	public BasicDBObject getClientObject(Client client);
	public List<Client> getAllClients();
	public boolean supprimerToutLesClients();
}
