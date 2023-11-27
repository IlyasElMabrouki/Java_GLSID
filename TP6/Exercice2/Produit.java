package Exercice2;

import java.io.Serializable;
import java.util.Objects;

public class Produit implements Serializable {
    private int id;
    private String nom;
    private String marque;
    private float prix;
    private String description;
    private int nbrStock;

    public Produit(int id, String nom, String marque, float prix, String description, int nbrStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrStock=" + nbrStock +
                '}';
    }
}
