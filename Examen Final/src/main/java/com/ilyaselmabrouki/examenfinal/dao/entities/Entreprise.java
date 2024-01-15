package com.ilyaselmabrouki.examenfinal.dao.entities;

import java.io.Serializable;

public class Entreprise implements Serializable {
    private int id;
    private String nom;

    private String adresse;
    private String telephone;
    private String email;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Entreprise : [id= " + id + ", nom= " + nom + ", adresse= " + adresse + ", telephone= " + telephone + ", email= " + email + "]";
    }
}
