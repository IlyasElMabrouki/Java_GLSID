import java.util.*;

public class Client {
    private String nom,prenom,adresse,email,ville,telephone;
    private ArrayList<Commande> commandes;
    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone, ArrayList<Commande> commandes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandes = new ArrayList<>();
        this.commandes.addAll(commandes);
    }
    public boolean ajouterCommande(Commande commande) {
        if (this.commandes.contains(commande)){
            return false;
        }
        return this.commandes.add(commande);
    }
    public boolean supprimerCommande(Commande commande) {
        return this.commandes.remove(commande);
    }
}