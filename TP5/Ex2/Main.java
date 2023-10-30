package Ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
        CompteBancaire cb1 = new CompteBancaire(1, 1000, "Ilyas El Mabrouki");
        CompteBancaire cb2 = new CompteBancaire(2, 1000, "Ilyas El Mabrouki");
        comptes.add(cb1);
        comptes.add(cb2);

        try {
            cb2.depot(200);
            cb2.retrait(1300);
            cb1.transferer(comptes, cb2,100);
            cb2.afficher();
            comptes.remove(cb2);
            cb1.transferer(comptes,cb2,200);
        }
        catch (FondsInsuffisantsException | CompteInexistantException e){
            System.out.println(e.getMessage());
        }
    }
}
