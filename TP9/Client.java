import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String ip,int port){
        try {
            this.s = new Socket(ip,port);
            this.in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()),true);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Client c = new Client("localhost", 9090);
        try {
        System.out.println(c.in.readLine());
        Scanner sc = new Scanner(System.in);
        c.out.println(sc.nextLine());
        while (true) {
            c.out.println(sc.nextInt());
            System.out.println(c.in.readLine());
        }
    }catch (Exception e) {
        e.printStackTrace();
    }

    }
}