package Ex2;

public class Sommeur implements Runnable{
    private int tab[];
    private int debut, fin, somme;
    public Sommeur(int[] tab, int debut, int fin){
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
    }

    public int getSomme(){
        return this.somme;
    }

    @Override
    public void run() {
        for (int i=debut;i<=fin;i++){
            this.somme+= tab[i];
        }
        System.out.println(this.getSomme());
    }
}
