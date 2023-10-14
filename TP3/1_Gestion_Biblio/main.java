public class main {

  public static void main(String[] args) {
    Adherant ad1 = new Adherant(
      7,
      "El Mabrouki",
      "Ilyas",
      "ilyas@gmail.com",
      "0777402279",
      21
    );
    Livre livre1 = new Livre(
      23,
      new Auteur(
        10,
        "Paulo",
        "Coelho",
        "paulofmcoelho@gmail.com",
        "00351937888888",
        76
      )
    );
    System.out.println(ad1.toString());
    System.out.println(livre1.toString());
  }
}
