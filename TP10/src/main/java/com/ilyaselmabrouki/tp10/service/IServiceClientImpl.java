package com.ilyaselmabrouki.tp10.service;

import com.ilyaselmabrouki.tp10.dao.ClientDaoImpl;
import com.ilyaselmabrouki.tp10.dao.entities.Client;

import java.util.List;

public class IServiceClientImpl implements IClientService {
    ClientDaoImpl clientDao;

    public IServiceClientImpl(ClientDaoImpl clientDao) {
        this.clientDao = clientDao ;
    }
    @Override
    public void addClient(Client c) {
        this.clientDao.save(c);
    }

    @Override
    public void deleteClientById(Integer id) {
        this.clientDao.removeById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientDao.getAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return this.clientDao.getById(id);
    }

    @Override
    public List<Client> searchClientByQuery(String query) {
        return this.clientDao.searchClientByQuery(query);
    }
}
