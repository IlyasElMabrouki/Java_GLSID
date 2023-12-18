package com.ilyaselmabrouki.tp10.presentation;

import com.ilyaselmabrouki.tp10.dao.ClientDaoImpl;
import com.ilyaselmabrouki.tp10.dao.entities.Client;
import com.ilyaselmabrouki.tp10.service.IServiceClientImpl;

import java.util.ArrayList;

public class ClientMain {
    public static void main(String[] args) {
        IServiceClientImpl ci = new IServiceClientImpl(new ClientDaoImpl());

        Client c = new Client();
        c.setNom("El Mabrouki");
        c.setPrenom("Ilyas");
        c.setEmail("ilyas@gmail.com");
        c.setAdresse("Kenitra, Maroc");

        //Add Client
        ci.addClient(c);
        ci.addClient(c);
        ci.addClient(c);

        //Delete Client
        ci.deleteClientById(2);

        //Get Client
        Client c1 = ci.getClientById(1);
        System.out.println(c1);

        //Get All Clients
        ArrayList<Client> clients = (ArrayList<Client>) ci.getAllClients();
        for (Client c2 : clients) {
            System.out.println(c2);
        }

        // Search Clients
        ArrayList<Client> searchedClients = (ArrayList<Client>) ci.searchClientByQuery("ma");
        for (Client c3 : searchedClients) {
            System.out.println(c3);
        }
    }
}
