package com.ilyaselmabrouki.examenfinal.dao.Impl;

import com.ilyaselmabrouki.examenfinal.dao.DepartementDao;
import com.ilyaselmabrouki.examenfinal.dao.SingletonConnexionDB;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartementDaoImpl implements DepartementDao {

    @Override
    public List<Departement> findAll() {
        ArrayList<Departement> departements = new ArrayList<>();
        try {
            Statement stm = SingletonConnexionDB.getConnexion().createStatement();
            ResultSet rs = stm.executeQuery("Select * from departement");
            while(rs.next()){
                Departement departement= new Departement();
                departement.setId(rs.getInt(1));
                departement.setNom(rs.getString(2));
                departement.setEntreprise(new EntrepriseDaoImpl().findById(rs.getInt(3)));
                departements.add(departement);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public Departement findById(Integer id) {
        Departement departement = new Departement();
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("Select * from departement where id = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                departement.setId(rs.getInt(1));
                departement.setNom(rs.getString(2));
                departement.setEntreprise(new EntrepriseDaoImpl().findById(rs.getInt(3)));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return departement;
    }

    @Override
    public void save(Departement o) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("INSERT INTO departement (nom, entreprise) VALUES (?, ?)");
            pstm.setString(1, o.getNom());
            pstm.setInt(2,o.getEntreprise().getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("DELETE from departement where id = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Departement o, Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("UPDATE departement set nom = ?, entreprise = ? where id = ?");
            pstm.setString(1, o.getNom());
            pstm.setInt(2,o.getEntreprise().getId());
            pstm.setInt(3, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
