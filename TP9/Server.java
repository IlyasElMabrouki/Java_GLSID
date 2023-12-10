import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9090);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            List<Socket> clients = new ArrayList<>();
            int magicNumber = new Random().nextInt(100);
            System.out.println(magicNumber);
            while(true){
                Socket s = ss.accept();
                clients.add(s);
                executorService.submit(new Service(s,clients, magicNumber));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
