package Exercice4;

import java.util.Scanner;

public class Chaine {
    private String ch;
    int[] nb_occurences = new int[26];
    public Chaine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer une ligne de texte (max. 100 caractéres):");
        ch = sc.nextLine().toLowerCase();
    }

    public int getIndex(char c){
        return ((int)c) - 97;
    }
    public char getValue(int num){
        return (char)(num+97);
    }

    public void calculer(){
        for (int i=0;i<ch.length();i++) {
            nb_occurences[getIndex(ch.charAt(i))]++;
        }
    }

    public void afficher(){
        calculer();
        System.out.println("La chaine '" + ch + "' contient:");
        for (int i=0;i<nb_occurences.length;i++) {
            if (nb_occurences[i] != 0){
                System.out.println(nb_occurences[i] + " fois la lettre " + getValue(i));
            }
        }
    }
}
