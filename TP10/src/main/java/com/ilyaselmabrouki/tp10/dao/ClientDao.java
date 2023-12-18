package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Client;

import java.util.List;

public interface ClientDao extends DAO<Client, Integer> {
    List<Client> searchClientByQuery(String query);
}
