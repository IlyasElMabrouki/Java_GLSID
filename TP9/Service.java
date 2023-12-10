import java.io.*;
import java.net.Socket;
import java.util.List;

public class Service implements Runnable {
    private Socket s;
    private List<Socket> clients;
    private BufferedReader in;
    private PrintWriter out;
    private int magicNumber;

    private String name;

    public Service(Socket s, List<Socket> clients, int magicNumber){
        this.s = s;
        this.clients = clients;
        try {
            this.in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()),true);
            this.magicNumber = magicNumber;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void brodcast(String msg){
        try {
            for(Socket client:clients){
                if (client != s) {
                    new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true).println(msg);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            out.println("Bienvenue, Veuillez entrer votre nom:");
            this.name = in.readLine();
            int nb;
            while(true){
                nb = Integer.parseInt(in.readLine());
                if (nb > magicNumber) out.println("Entrer une valeur plus petite");
                else if (nb < magicNumber) out.println("Entrer une valeur plus grande");
                else {
                    out.println("Bravo vous avez gagne");
                    brodcast("Le nombre magique " + magicNumber + " a ete touve par " + this.name);
                    s.close();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
