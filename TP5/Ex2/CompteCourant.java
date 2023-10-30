package Ex2;

public class CompteCourant extends CompteBancaire{

    private boolean decouvert;

    public CompteCourant(int numCompte, int solde, String nomTitulaire,boolean decouvert) {
        super(numCompte, solde, nomTitulaire);
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return super.toString() + "Decouvert:" + this.decouvert;

    }
}
