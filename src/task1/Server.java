package task1;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
       // List<String> resultFG = new LinkedList<>();
        Socket socket = null;
        ObjectInputStream objectInputStream=null;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            System.out.println("Start");
            try {
                socket = serverSocket.accept();
                objectInputStream=new ObjectInputStream(socket.getInputStream());

                    Person person = (Person) objectInputStream.readObject();
                    System.out.println(person.toString());

                socket.close();

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
