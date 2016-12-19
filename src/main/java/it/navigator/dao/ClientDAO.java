package it.navigator.dao;

import it.navigator.entity.Client;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
public interface ClientDAO {
    public List<Client> getAllClient();

    public void update(Client client);

    public void updateAll(List<Client> list);
}
