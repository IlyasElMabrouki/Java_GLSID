import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
    private List<Produit> produits;

    public MetierProduitImpl(){
        produits = new ArrayList<>();
    }

    @Override
    public void add(Produit o) {
        Produit p = findById(o.getId());
        if (p == null) this.produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for(Produit p: this.produits){
            if(p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit p = findById(id);
        if (p != null) this.produits.remove(p);
    }
}
