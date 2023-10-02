package Exercice1;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static float moy(float[] notes){
        float somme = 0;
        for (float note : notes) {
            somme += note;
        }
        return somme/notes.length;
    }
    public static float max(float[] notes){
        float max = notes[0];
        for (float note : notes) {
            if (max < note) {
                max = note;
            }
        }
        return max;
    }

    public static float min(float[] notes){
        float min = notes[0];
        for (float note : notes) {
            if (min > note) {
                min = note;
            }
        }
        return min;
    }

    public static int noteNumber(float[] notes, float note){
        int number = 0;
        for (float v : notes) {
            if (note == v) {
                number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nombre de notes:");
        int nbNotes = sc.nextInt();
        float notes[] = new float[nbNotes];
        for (int i=0;i<nbNotes;i++){
            System.out.println("Entrer la note :");
            notes[i] = sc.nextFloat();
        }

        System.out.println("Affichage des notes triées :");
        Arrays.sort(notes);
        for (float nb: notes) {
            System.out.print(nb + " ");
        }

        System.out.println();
        System.out.println("Note Moyenne");
        float moyNote = moy(notes);
        System.out.println(moyNote);
        
        System.out.println("Note Maximale");
        float maxNote = max(notes);
        System.out.println(maxNote);

        System.out.println("Note Minimale");
        float minNote = min(notes);
        System.out.println(minNote);

        System.out.println("Entrer une note:");
        float note = sc.nextFloat();
        int noteNumber = noteNumber(notes,note);
        System.out.println(noteNumber + " étudiants qui ont eu la note " + note);

    }
}

