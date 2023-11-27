package Exercice1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Entre le chemin");
        Scanner sc = new Scanner(System.in);
        try {
            Fichier f = new Fichier(sc.nextLine());
            f.getFilesList();
        }
        catch (Exception e){
            System.out.println("Chemin invalidade");
        }
    }
}
