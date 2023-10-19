public class Main {

    public static void main(String[] args) {
        Ingenieur ing1 = new Ingenieur("El Mabrouki", "Ilyas", "ilyas@gmail.com","0777402279",10000,"IT");
        System.out.println(ing1.toString());
        System.out.println(ing1.calculerSalaire());

        Manager man1 = new Manager("Musk", "Elon", "musk@mail.com","0030829839",20000,"IT");
        System.out.println(man1.toString());
        System.out.println(man1.calculerSalaire());
    }
}
