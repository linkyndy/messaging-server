package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

class MessageQueueSenderClient {
    public static void main(String args[]) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Sends a new message...
        out.println("PUSH");
        // with text...
        out.println("New message");
        // to...
        out.println("receiver");
        out.flush();

        /* Optionally check response from server */

        s.close();
    }
}

class MessageQueueReceiverClient {
    public static void main(String args[]) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Asks for new message...
        out.println("POP");
        // for itself...
        out.println("receiver");
        out.flush();

        // Wait for server response
        String message = in.readLine();
        if (message != null) {
            System.out.println(message);
        }

        s.close();
    }
}

class TopicClient {
    public static void main(String args[]) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Adds a new topic
        out.println("ADD_TOPIC");
        out.println("Topic name");
        out.flush();

        /* Optionally check response from server */

        s.close();
    }
}
