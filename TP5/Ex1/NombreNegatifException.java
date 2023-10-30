package Ex1;

public class NombreNegatifException extends Exception{
    private int val;
    public NombreNegatifException(String message, int val){
        super(message);
        this.val = val;
    }
    public int getValue(){
        return this.val;
    }
}
