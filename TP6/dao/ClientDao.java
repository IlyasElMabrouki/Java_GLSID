package com.ilyaselmabrouki.tp8.dao;

import com.ilyaselmabrouki.tp8.dao.entities.Client;

import java.util.List;

public interface ClientDao extends DAO<Client, Integer> {
    List<Client> searchClientByQuery(String query);
}
