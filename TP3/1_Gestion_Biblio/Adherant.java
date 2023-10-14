public class Adherant extends Personne {

  private int numAdherant;

  Adherant(
    int numAdherant,
    String nom,
    String prenom,
    String email,
    String tel,
    int age
  ) {
    super(nom, prenom, email, tel, age);
    this.numAdherant = numAdherant;
  }

  public String toString(){
    String infos = "Personne: " + super.toString() + "\n";
    return infos += "Num Adherant:" + this.numAdherant;
  }
}
