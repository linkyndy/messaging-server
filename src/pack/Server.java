package pack;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;

import pack.MessageQueueInterface;
import pack.TopicListInterface;


public class Server {
    // Holds all synchronized topiclist/messagequeue methods as a single
    // instance to be shared across all clients
    private static final TopicListInterface tli = new TopicListInterface();
    private static final MessageQueueInterface mqi = new MessageQueueInterface(20);

    private static ServerSocket ss;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        Socket s;
        Thread t;

        try {
            ss = new ServerSocket(PORT);

            while(true) {
                s = ss.accept();

                // Send both the TopicInterface and MessageQueueInterface to the client;
                // he will decide if he is going to send a Post or a Message
                t = new Thread(new Client(s, tli, mqi));
                t.start()
            }
        } catch (SocketException e) {
            System.exit(1);
        } catch (IOException e) {
            System.exit(1);
        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (Exception e) {
                    System.exit(1);
                }
            }
        }
    }
}
