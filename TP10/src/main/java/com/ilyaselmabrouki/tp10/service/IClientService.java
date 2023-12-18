package com.ilyaselmabrouki.tp10.service;

import com.ilyaselmabrouki.tp10.dao.entities.Client;

import java.util.List;

public interface IClientService {
    void addClient(Client c);
    void deleteClientById(Integer id);
    List<Client> getAllClients();
    Client getClientById(Integer id);
    List<Client> searchClientByQuery(String query);
}
