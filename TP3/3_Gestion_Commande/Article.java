public class Article {
    private String nom;

    private String marque;

    private double prix;

    private String description;

    private int nbrStock;

    public Article(String nom, String marque, double prix, String description, int nbrStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public double getPrix(int quantity){
        return this.prix * quantity;
    }
}
