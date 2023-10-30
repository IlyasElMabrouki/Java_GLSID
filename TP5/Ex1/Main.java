package Ex1;

public class Main {
    public static void main(String[] args) {
        try {
            EntierNaturel et = new EntierNaturel(12);
            System.out.println(et.getVal());
            et.setVal(0);
            System.out.println(et);
            et.decrementer();
            System.out.println(et);
        }
        catch (NombreNegatifException e){
            System.out.println(e.getMessage());
            System.out.println(e.getValue());
        }
    }
}