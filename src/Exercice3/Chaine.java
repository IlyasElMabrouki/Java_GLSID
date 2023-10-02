package Exercice3;

import java.util.Scanner;

public class Chaine {
    private String chaine;

    public void saisir(){
        Scanner sc = new Scanner(System.in);
        chaine = sc.nextLine();
    }

    public void afficher(){
        System.out.println(chaine);
    }

    public void inverser(){
        StringBuilder sb = new StringBuilder(chaine);
        chaine = sb.reverse().toString();
    }

    public int nombreMots(){
        String[] mots = chaine.split(" ");
        int length = 0;
        for (String mot:mots) {
           if (!mot.trim().isEmpty()) length++;
        }
        return length;
    }

    public int menu(){
        System.out.println("Menu d'opérations sur les chaines de caractères:");
        System.out.println("1.Saisir");
        System.out.println("2.Afficher");
        System.out.println("3.Inverser");
        System.out.println("4.Nombre de mots");
        System.out.println("Entrer le chiffre correspondant à l'opération voulu:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void retourMenu(){
        System.out.println("Frapper une touche pour revenir au menu");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
