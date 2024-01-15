package com.ilyaselmabrouki.examenfinal.dao.Impl;

import com.ilyaselmabrouki.examenfinal.dao.EmployeDao;
import com.ilyaselmabrouki.examenfinal.dao.SingletonConnexionDB;
import com.ilyaselmabrouki.examenfinal.dao.entities.Employe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeDaoImpl implements EmployeDao {
    @Override
    public List<Employe> findAll() {
        ArrayList<Employe> employes = new ArrayList<>();
        try {
            Statement stm = SingletonConnexionDB.getConnexion().createStatement();
            ResultSet rs = stm.executeQuery("Select * from employe");
            while(rs.next()){
                Employe employe = new Employe();
                employe.setId(rs.getInt(1));
                employe.setNom(rs.getString(2));
                employe.setPoste(rs.getString(3));
                employe.setSalaire(rs.getDouble(4));
                employe.setDepartement(new DepartementDaoImpl().findById(rs.getInt(5)));
                employes.add(employe);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return employes;
    }

    @Override
    public Employe findById(Integer id) {
        Employe employe = new Employe();
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("Select * from employe where id = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                employe.setId(rs.getInt(1));
                employe.setNom(rs.getString(2));
                employe.setPoste(rs.getString(3));
                employe.setSalaire(rs.getDouble(4));
                employe.setDepartement(new DepartementDaoImpl().findById(rs.getInt(5)));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return employe;
    }

    @Override
    public void save(Employe o) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("INSERT INTO employe (nom, poste, salaire, departement) VALUES (?, ?, ?, ?)");
            pstm.setString(1, o.getNom());
            pstm.setString(2, o.getPoste());
            pstm.setDouble(3, o.getSalaire());
            pstm.setInt(4,o.getDepartement().getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("DELETE from employe where id = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employe o, Integer id) {
        try {
            PreparedStatement pstm = SingletonConnexionDB.getConnexion()
                    .prepareStatement("UPDATE employe set nom = ?, poste = ?, salaire = ?, departement = ? where id = ?");
            pstm.setString(1, o.getNom());
            pstm.setString(2, o.getPoste());
            pstm.setDouble(3, o.getSalaire());
            pstm.setInt(4,o.getDepartement().getId());
            pstm.setInt(5, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
