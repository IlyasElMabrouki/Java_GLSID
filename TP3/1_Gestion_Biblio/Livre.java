public class Livre {
    private int ISBN;
    private Auteur aut;

    Livre(int ISBN, Auteur aut){
        this.ISBN = ISBN;
        this.aut = aut;
    }

    public String toString(){
        return "Livre ISBN: " + this.ISBN + "\n" + this.aut.toString();
    }
}
