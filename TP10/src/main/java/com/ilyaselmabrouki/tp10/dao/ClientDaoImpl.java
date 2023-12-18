package com.ilyaselmabrouki.tp10.dao;

import com.ilyaselmabrouki.tp10.dao.entities.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void save(Client o) {
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Insert into Client (nom,prenom,email,adresse) values (?,?,?,?)");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getPrenom());
            pstm.setString(3,o.getEmail());
            pstm.setString(4,o.getAdresse());
            pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(Integer id) {
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Delete from Client where id = ?");
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Client getById(Integer id) {
        Client c = new Client();
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Select * from Client where id = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAdresse(rs.getString(5));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            Statement stm = DBConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("Select * from Client");
            while(rs.next()){
                Client c= new Client();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAdresse(rs.getString(5));
                clients.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public List<Client> searchClientByQuery(String query) {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement("Select * from Client where nom like ?");
            pstm.setString(1,'%' + query + '%');
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Client c= new Client();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAdresse(rs.getString(5));
                clients.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }
}
