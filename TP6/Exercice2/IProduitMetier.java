package Exercice2;

import java.util.List;

public interface IProduitMetier {
    public Produit add(Produit p);
    public List<Produit> getAll() throws Exception;

    public Produit findById(int id);

    public void delete(int id);

    public void saveAll() throws Exception;
}
