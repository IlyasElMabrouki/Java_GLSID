package com.ilyaselmabrouki.examenfinal.dao.Impl;

import com.ilyaselmabrouki.examenfinal.dao.EntrepriseDao;
import com.ilyaselmabrouki.examenfinal.dao.SingletonConnexionDB;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseDaoImpl implements EntrepriseDao {
    @Override
    public List<Entreprise> findAll() {
        ArrayList<Entreprise> entreprises = new ArrayList<>();
        try {
            Statement stm = SingletonConnexionDB.getConnexion().createStatement();
            ResultSet rs = stm.executeQuery("Select * from entreprise");
            while(rs.next()){
                Entreprise entreprise= new Entreprise();
                entreprise.setId(rs.getInt(1));
                entreprise.setNom(rs.getString(2));
                entreprise.setAdresse(rs.getString(3));
                entreprise.setTelephone(rs.getString(4));
                entreprise.setEmail(rs.getString(5));
                entreprises.add(entreprise);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return entreprises;
    }

    @Override
    public Entreprise findById(Integer id) {
        Entreprise entreprise = new Entreprise();
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("Select * from entreprise where id = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                entreprise.setId(rs.getInt(1));
                entreprise.setNom(rs.getString(2));
                entreprise.setAdresse(rs.getString(3));
                entreprise.setTelephone(rs.getString(4));
                entreprise.setEmail(rs.getString(5));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return entreprise;
    }

    @Override
    public void save(Entreprise o) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("INSERT INTO entreprise (nom, adresse, telephone, email) VALUES (?, ?, ?, ?)");
            pstm.setString(1, o.getNom());
            pstm.setString(2, o.getEmail());
            pstm.setString(3, o.getTelephone());
            pstm.setString(4, o.getTelephone());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("DELETE from entreprise where id = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Entreprise o, Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("UPDATE entreprise set nom = ?, adresse = ?, telephone = ?, email= ? where id = ?");
            pstm.setString(1, o.getNom());
            pstm.setString(2,o.getAdresse());
            pstm.setString(3,o.getTelephone());
            pstm.setString(4, o.getEmail());
            pstm.setInt(5, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Entreprise> searchByKey(String key) {
        return null;
    }

    @Override
    public ArrayList<Departement> findDepartements(Entreprise entreprise) {
        return null;
    }

    @Override
    public void print() {

    }
}
