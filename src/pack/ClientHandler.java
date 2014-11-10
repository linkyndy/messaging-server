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

        // Holds topic ID to be sent when creating a new topic
        int id = 0;

        try {
            in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()));

            // Retrieve action sent by client
            String action;
            action = in.readLine();

            String response = "";
            int topic_id;

            /*
            All responses below must be converted to String
            */
            switch (action) {
                case "GET_TOPICS":
                    response = this.tli.getTopics().toString();
                    break;
                case "ADD_TOPIC":
                    String title = in.readLine();
                    response = this.tli.addTopic(title, id++);
                    break;
                case "GET_POSTS":
                    topic_id = Integer.parseInt(in.readLine());
                    response = this.tli.getPosts(topic_id).toString();
                    break;
                case "ADD_POST":
                    topic_id = Integer.parseInt(in.readLine());
                    String text = in.readLine();
                    int expires = Integer.parseInt(in.readLine());
                    response = this.tli.addPost(topic_id, text, expires);
                    break;
                case "PUSH":
                    String _title = in.readLine();
                    String receiver = in.readLine();
                    response = this.mqi.push(_title, receiver);
                    break;
                case "POP":
                    String _receiver = in.readLine();
                    response = this.mqi.pop(_receiver);
                    break;
            }

            out.write(response + "\n");
            out.flush();

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
