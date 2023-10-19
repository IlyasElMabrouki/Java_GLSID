public class Ingenieur extends Employe{

    private String specialite;

    public Ingenieur(String nom, String prenom, String email, String telephone, double salaire, String specialite) {
        super(nom,prenom,email,telephone,salaire);
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
        return super.getSalaire() + super.getSalaire() * 0.15;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIngénieur: spécialité:" + this.specialite;
    }
}
