package Ex2;

public class CompteEpargne extends CompteBancaire{

    private float tauxInteret;
    public CompteEpargne(int numCompte, int solde, String nomTitulaire, float tauxInteret) {
        super(numCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return super.toString() + ", Taux du interet :" + tauxInteret;
    }
}
