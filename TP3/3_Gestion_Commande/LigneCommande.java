public class LigneCommande {
    private int quantite;
    private Commande commande;
    private Article article;
    public LigneCommande(int quantite, Commande commande, Article article) {
        this.quantite = quantite;
        this.commande = commande;
        this.article = article;
    }
}
