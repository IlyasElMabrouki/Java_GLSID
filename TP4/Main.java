import java.util.Scanner;

public class Main {

    public static int menu(){
        System.out.println("Menu d'opérations sur la liste des produits:");
        System.out.println("1.Afficher tous les produits");
        System.out.println("2.Rechercher un produit par son id");
        System.out.println("3.Ajouter un nouveau produit dans la liste");
        System.out.println("4.Supprimer un produit par id");
        System.out.println("5.Quitter produit");
        System.out.println("Entrer le chiffre correspondant à l'opération voulu:");
        Scanner sc2 = new Scanner(System.in);
        return sc2.nextInt();
    }

    public static Produit saisir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer ID:");
        long id = sc.nextLong();
        System.out.println("Entrer Nom:");
        String nom = sc.next();
        System.out.println("Entrer Marque:");
        String marque = sc.next();
        System.out.println("Entrer prix:");
        double prix = sc.nextDouble();
        System.out.println("Entrer description:");
        String desc = sc.next();
        System.out.println("Entrer Nombre stock:");
        int nbr = sc.nextInt();

        return new Produit(id,nom,marque,prix,desc,nbr);
    }

    public static void retourMenu(){
        System.out.println("Frapper une touche pour revenir au menu");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MetierProduitImpl produits = new MetierProduitImpl();
        int choix;
        Scanner sc1 = new Scanner(System.in);
        do {
            choix = Main.menu();
            switch (choix) {
                case 1:
                    for (Produit p: produits.getAll()) System.out.println(p);
                    Main.retourMenu();
                    break;
                case 2:
                    System.out.println("Entrer un ID");
                    long id = sc1.nextLong();
                    System.out.println(produits.findById(id));
                    Main.retourMenu();
                    break;
                case 3:
                    Produit p = Main.saisir();
                    produits.add(p);
                    Main.retourMenu();
                    break;
                case 4:
                    System.out.println("Entrer un ID");
                    long idDelete = sc1.nextLong();
                    produits.delete(idDelete);
                    Main.retourMenu();
                    break;
                case 5:
                    System.out.println("Au revoir");
                    choix = 0;
                    break;
                default:
                    System.out.println("Veuillez choisir un chiffre valable");
                    Main.retourMenu();
            }
        } while (choix != 0);
    }
}