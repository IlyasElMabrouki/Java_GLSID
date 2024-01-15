package com.ilyaselmabrouki.examenfinal.metier;

import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Employe;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;

import java.util.ArrayList;
import java.util.List;

public interface IEntrepriseMetier {

    //Entreprise
    List<Entreprise> getAllEntreprises();
    Entreprise getEntreprise(Integer id);
    void addEntreprise(Entreprise entreprise);
    void deleteEntreprise(Integer id);
    void updateEntreprise(Entreprise entreprise, Integer id);
    ArrayList<Entreprise> searchByKey(String key);
    ArrayList<Departement> findDepartements(Entreprise entreprise);
    void print();

    //Departement
    List<Departement> getAllDepartements();
    Departement getDepartement(Integer id);
    void addDepartement(Departement departement);
    void deleteDepartement(Integer id);
    void updateDepartement(Departement departement, Integer id);

    //Employe
    List<Employe> getAllEmployes();
    Employe getEmploye(Integer id);
    void addEmplye(Employe employe);
    void deleteEmploye(Integer id);
    void updateEmploye(Employe employe, Integer id);
}
