package Ex2;

import java.util.ArrayList;

public class CompteBancaire {
    private int numCompte;
    private int solde;
    private String nomTitulaire;
    public CompteBancaire(int numCompte, int solde, String nomTitulaire) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }
    @Override
    public String toString() {
        return "CompteBancaire : numCompte=" + numCompte + ", solde=" + solde + ", nomTitulaire='" + nomTitulaire;
    }
    public void depot(int value){
        solde += value;
    }
    public void retrait(int value) throws FondsInsuffisantsException{
        if (value>solde) throw new FondsInsuffisantsException("Valeur Invalide");
        solde -= value;
    }
    public void afficher(){
        System.out.println("Votre solde est: " + solde + " DHs");
    }
    public void transferer(ArrayList<CompteBancaire> compteBancaires, CompteBancaire cb, int value) throws FondsInsuffisantsException,
            CompteInexistantException{
        if (value>solde) throw new FondsInsuffisantsException("Valeur Invalide");
        if (!compteBancaires.contains(cb)) throw new CompteInexistantException("Compte Inexistant");
        this.retrait(value);
        cb.depot(value);
    }

}
