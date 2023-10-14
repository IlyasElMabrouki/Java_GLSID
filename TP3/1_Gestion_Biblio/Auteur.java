public class Auteur extends Personne {

  private int numAuteur;

  Auteur(
    int numAuteur,
    String nom,
    String prenom,
    String email,
    String tel,
    int age
  ) {
    super(nom, prenom, email, tel, age);
    this.numAuteur = numAuteur;
  }

  public String toString() {
    return "Personne: " + super.toString() + "\nAuteur: Num Auteur:" + this.numAuteur;
  }
}
