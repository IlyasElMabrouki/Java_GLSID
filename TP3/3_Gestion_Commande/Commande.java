import java.text.SimpleDateFormat;
import java.util.*;

public class Commande {
    private int reference;
    private Date dateCommande;
    private Etat etatCommande;
    public Commande(int reference, Date dateCommande, Etat etatCommande) {
        this.reference = reference;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
    }
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(this.dateCommande);
        return "Commande : \nReference:" + this.reference + ", Date:" + date + ", Etat:" + this.etatCommande;
    }
}