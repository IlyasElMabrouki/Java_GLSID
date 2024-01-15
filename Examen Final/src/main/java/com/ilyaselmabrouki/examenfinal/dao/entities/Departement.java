package com.ilyaselmabrouki.examenfinal.dao.entities;

import java.io.Serializable;

public class Departement implements Serializable {
    private int id;
    private String nom;

    private Entreprise entreprise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "Departement : [id= " + id + ", nom= " + nom + " " + entreprise + "]";
    }
}
