package Ex1;

public class EntierNaturel {
    private int val;
    public EntierNaturel(int val) throws NombreNegatifException {
        if (val <0) throw new NombreNegatifException("Valeur Negatif",val);
        this.val = val;
    }
    public int getVal() {
        return this.val;
    }
    public void setVal(int val) throws NombreNegatifException {
        if (val <0) throw new NombreNegatifException("Valeur Negatif",val);
        this.val = val;
    }
    public void decrementer() throws NombreNegatifException {
        if (val -1 <0) throw new NombreNegatifException("Valeur Negatif",val);
        this.val--;
    }
    @Override
    public String toString() {
        return "La valeur est: " + val;
    }
}

