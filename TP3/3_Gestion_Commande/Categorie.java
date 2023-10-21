import java.util.ArrayList;

public class Categorie {
    private String nom;
    private String description;
    ArrayList<Article> articles;
    public Categorie(String nom, String description, ArrayList<Article> articles) {
        this.nom = nom;
        this.description = description;
        this.articles = new ArrayList<>();
        this.articles.addAll(articles);
    }
    public boolean ajouterArticle(Article article) {
        if (this.articles.contains(article)){
            return false;
        }
        return this.articles.add(article);
    }
    public boolean supprimerArticle(Article article) {
        return this.articles.remove(article);
    }
    public ArrayList<Article> rechercherParPrix(double prix) {
        ArrayList<Article> articles = new ArrayList<>();
        for (Article article: this.articles){
            if(article.getPrix(1) == prix) articles.add(article);
        }
        return articles;
    }

}