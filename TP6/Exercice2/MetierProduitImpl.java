package Exercice2;

import java.io.*;
import java.util.ArrayList;

public class MetierProduitImpl implements IProduitMetier{
    private ArrayList<Produit> produits;
    private String nomFichier;

    public MetierProduitImpl(String nomFichier){
        this.nomFichier = nomFichier;
        this.produits = new ArrayList<Produit>();
    }

    public Produit add(Produit p) {
        produits.add(p);
        return p;
    }

    @Override
    public ArrayList<Produit> getAll() throws Exception {
        FileInputStream fos = new FileInputStream("produits.dat");
        ObjectInputStream ois = new ObjectInputStream(fos);
        this.produits = (ArrayList<Produit>) ois.readObject();
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for (Produit p: produits) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Produit p = findById(id);
        if (p != null){
            produits.remove(p);
        }
    }

    @Override
    public void saveAll() throws Exception {
        FileOutputStream fos = new FileOutputStream("produits.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Produit p:produits) {
            oos.writeObject(p);
        }
    }
}
