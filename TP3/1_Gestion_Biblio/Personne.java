public class Personne {

  private String nom;
  private String prenom;
  private String email;
  private String tel;
  private int age;

  Personne(String nom, String prenom, String email, String tel, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.tel = tel;
    this.age = age;
  }

  public String toString() {
    return (
      "Nom: " +
      this.nom +
      ", Prenom: " +
      this.prenom +
      ", email: " +
      this.email +
      ", tel:" +
      this.tel +
      ", age:" +
      this.age
    );
  }
}
