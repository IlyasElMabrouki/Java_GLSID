package Exercice3;

public class Application {

    public static void main(String[] args) {
        Chaine ch1 = new Chaine();
        int choix;
        do {
            choix = ch1.menu();
            switch (choix) {
                case 1:
                    ch1.saisir();
                    ch1.retourMenu();
                    break;
                case 2:
                    ch1.afficher();
                    ch1.retourMenu();
                    break;
                case 3:
                    ch1.inverser();
                    ch1.afficher();
                    ch1.retourMenu();
                    break;
                case 4:
                    System.out.println(ch1.nombreMots());
                    ch1.retourMenu();
                    break;
                case 0:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Veuillez choisir un chiffre valable");
                    ch1.retourMenu();
            }
        } while (choix != 0);
    }
}
