package Exercice2;

import java.util.Scanner;

public class Verbe {
    private String verbe;
    private String terminaison[] = {"e", "es", "e", "ons", "ez", "ent"};
    private String pronoms[] = {"Je","Tu", "Il", "Nous", "Vous", "Ils"};

    public Verbe() throws Exception {
        Scanner sc = new Scanner(System.in);
        String vb = sc.next();
        if (!vb.endsWith("er")) throw new Exception("Verbe du premier groupe !!!");
        verbe = vb.substring(0, vb.length()-2);
    }

    public void conjuger(){
        for (int i=0;i<6;i++){
            System.out.println(pronoms[i] + " " + verbe + terminaison[i]);
        }
    }

}
