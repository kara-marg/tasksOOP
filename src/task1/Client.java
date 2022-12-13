package task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {



    public void write(int port) throws IOException, InterruptedException {
        Person person=Person.createRandomPerson();
        Socket socket = new Socket("127.0.0.1", port);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
        socket.close();
    }



}
