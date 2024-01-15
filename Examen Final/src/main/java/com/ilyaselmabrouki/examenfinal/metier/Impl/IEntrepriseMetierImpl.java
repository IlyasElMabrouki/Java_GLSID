package com.ilyaselmabrouki.examenfinal.metier.Impl;

import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Employe;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;
import com.ilyaselmabrouki.examenfinal.metier.IEntrepriseMetier;

import java.util.ArrayList;
import java.util.List;

public class IEntrepriseMetierImpl implements IEntrepriseMetier {

    EntrepriseDaoImpl entrepriseDao;
    DepartementDaoImpl departementDao;
    EmployeDaoImpl employeDao;

    public IEntrepriseMetierImpl(EntrepriseDaoImpl entrepriseDao, DepartementDaoImpl departementDao, EmployeDaoImpl employeDao) {
        this.entrepriseDao = entrepriseDao;
        this.departementDao = departementDao;
        this.employeDao = employeDao;
    }

    @Override
    public List<Entreprise> getAllEntreprises() {
        return this.entrepriseDao.findAll();
    }

    @Override
    public Entreprise getEntreprise(Integer id) {
        return this.entrepriseDao.findById(id);
    }

    @Override
    public void addEntreprise(Entreprise entreprise) {
        this.entrepriseDao.save(entreprise);
    }

    @Override
    public void deleteEntreprise(Integer id) {
        this.entrepriseDao.delete(id);
    }

    @Override
    public void updateEntreprise(Entreprise entreprise, Integer id) {
        this.entrepriseDao.update(entreprise,id);
    }

    @Override
    public ArrayList<Entreprise> searchByKey(String key) {
        return this.entrepriseDao.searchByKey(key);
    }

    @Override
    public ArrayList<Departement> findDepartements(Entreprise entreprise) {
        return this.entrepriseDao.findDepartements(entreprise);
    }

    @Override
    public void print() {
        this.entrepriseDao.print();
    }

    @Override
    public List<Departement> getAllDepartements() {
        return this.departementDao.findAll();
    }

    @Override
    public Departement getDepartement(Integer id) {
        return this.departementDao.findById(id);
    }

    @Override
    public void addDepartement(Departement departement) {
        this.departementDao.save(departement);
    }

    @Override
    public void deleteDepartement(Integer id) {
        this.departementDao.delete(id);
    }

    @Override
    public void updateDepartement(Departement departement, Integer id) {
        this.departementDao.update(departement,id);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return this.employeDao.findAll();
    }

    @Override
    public Employe getEmploye(Integer id) {
        return this.employeDao.findById(id);
    }

    @Override
    public void addEmplye(Employe employe) {
        this.employeDao.save(employe);
    }

    @Override
    public void deleteEmploye(Integer id) {
        this.employeDao.delete(id);
    }

    @Override
    public void updateEmploye(Employe employe, Integer id) {
        this.employeDao.update(employe, id);
    }
}
