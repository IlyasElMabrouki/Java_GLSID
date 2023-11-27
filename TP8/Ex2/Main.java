package Ex2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8,9,5};
        ExecutorService ex = Executors.newFixedThreadPool(2);

        Sommeur sm1 = new Sommeur(Arrays.copyOfRange(t, 0, 5),0,4);
        Sommeur sm2 = new Sommeur(Arrays.copyOfRange(t, 5, 10),0,4);

        try {
            ex.execute(sm1);
            ex.execute(sm2);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ex.shutdown();
        }

        while(!ex.isTerminated()){}

        int somme = sm1.getSomme() + sm2.getSomme();

        System.out.println(somme);
    }
}
