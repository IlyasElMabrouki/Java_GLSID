public class Reponse {

  private String titre;
  private boolean correcte;

  Reponse(String titre, boolean correcte) {
    this.titre = titre;
    this.correcte = correcte;
  }

  public String toString() {
    return titre + "\n";
  }

  public boolean getCorrecte() {
    return correcte;
  }
}
