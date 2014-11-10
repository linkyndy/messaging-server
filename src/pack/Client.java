package pack;

import java.net.Socket;
import java.net.SocketException;

class MessageQueueSenderClient {
    public static void main(String args[]) {
        Socket s = new Socket("localhost", 1234);

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Sends a new message...
        out.println("PUSH");
        // with text...
        out.println("New message");
        // to...
        out.println("receiver")
        out.flush();

        /* Optionally check response from server */

        s.close();
    }
}

class MessageQueueReceiverClient {
    public static void main(String args[]) {
        Socket s = new Socket("localhost", 1234);

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Asks for new message...
        out.println("POP");
        // for itself...
        out.println("receiver")
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
    public static void main(String args[]) {
        Socket s = new Socket("localhost", 1234);

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        // Adds a new topic
        out.println("ADD_TOPIC");
        out.println("Topic name");
        out.flush();

        /* Optionally check response from server */

        s.close();
    }
}
