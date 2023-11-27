package Exercice2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            Produit p1 = new Produit(1,"PC1","HP",1200,"Ordi rapide",10);
            MetierProduitImpl m = new MetierProduitImpl("");
            m.add(p1);
            m.saveAll();
            ArrayList<Produit> produits = m.getAll();
            for (Produit p:produits) {
                System.out.println(p.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
