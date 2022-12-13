package task1;

import java.io.IOException;

public class Main {
    private static final int port = 3009;
    private static final String ip = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {
        Runnable r = ()->{
            Server server=new Server(port);
            try {
                server.start();
            } catch (IOException e) {

            }
        };
        (new Thread(r, "Server")).start();
        Client client = new Client();
        client.write(port);
        client.write(port);
    }

}
