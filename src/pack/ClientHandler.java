package pack;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import pack.MessageQueueInterface;
import pack.TopicListInterface;


public class ClientHandler implements Runnable {
    private Socket s;
    private final TopicListInterface tli;
    private final MessageQueueInterface mqi;


    public ClientHandler(Socket s, final TopicListInterface tli, final MessageQueueInterface mqi ) {
        this.s = s;
        this.tli = tli;
        this.mqi = mqi;
    }


    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {

            in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()));


            /*
            Handle messages from client: make a distinction between a Post
            (which belongs to a Topic) and a Message (which has a receiver
            attached)

            Maybe listen to client socket and parse String input; this input
            may begin with custom headers, such as what operation the client
            wants to execute (1 for add topic; 2 for add post to topic; etc);
            build a switch statement and map these actions to TopicListInterface
            and MessageQueueInterface methods
            */


        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
				in.close();
				out.close();
	            this.s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    }
}
