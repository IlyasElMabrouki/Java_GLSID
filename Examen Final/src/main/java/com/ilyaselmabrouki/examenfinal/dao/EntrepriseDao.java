package com.ilyaselmabrouki.examenfinal.dao;

import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;

import java.util.ArrayList;

public interface EntrepriseDao extends Dao<Entreprise, Integer> {
    ArrayList<Entreprise> searchByKey(String key);

    ArrayList<Departement> findDepartements(Entreprise entreprise);

    void print();
}
