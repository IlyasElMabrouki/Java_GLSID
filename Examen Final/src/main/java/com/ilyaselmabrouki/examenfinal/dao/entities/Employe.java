package com.ilyaselmabrouki.examenfinal.dao.entities;

import java.io.Serializable;

public class Employe implements Serializable {
    private int id;
    private String nom;
    private String poste;
    private Double salaire;
    private Departement departement;

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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Employe [id=" + id + ", nom=" + nom + "poste=" + poste + "salaire=" + salaire + "departement=" + departement + "]";
    }
}
