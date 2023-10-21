import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Article> articles = new ArrayList<>();

        Article ordi1 = new Article("Ordinateur","Lenovo",4500.0, "Ordi simple à utiliser",20);
        articles.add(ordi1);

        Article ordi2 = new Article("Ordinateur","HP",3000, "Ordi trés performant",10);
        articles.add(ordi2);

        Article ordi3 = new Article("Ordinteur","Toshiba",4000, "Ordi puissant", 30 );
        articles.add(ordi3);

        Categorie ordinateurs = new Categorie("Oridateur","Liste des ordi populaires",articles);

        Commande commande = new Commande(23,new Date(), Etat.CONFIRME);

        ArrayList<Commande> commandes = new ArrayList<>();
        commandes.add(commande);

        Client ilyas = new Client("El Mabrouki","Ilyas","Ismailia","ilyas@gmail.com","Kenitra","0777402279",commandes);

        LigneCommande ligneCommande1 = new LigneCommande(2,commande, ordi1);
        LigneCommande ligneCommande2 = new LigneCommande(3,commande, ordi2);
        LigneCommande ligneCommande3 = new LigneCommande(1,commande, ordi3);

        System.out.println(commande);
    }
}
