package pack;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.io.IOException;

//import pack.MessageQueueInterface;
//import pack.TopicListInterface;


public class Server {
    // Holds all synchronized topiclist/messagequeue methods as a single
    // instance to be shared across all clients
    private static final TopicListInterface tli = new TopicListInterface();
    private static final MessageQueueInterface mqi = new MessageQueueInterface(20);

    private static ServerSocket ss;
    private static final int PORT = 1234;

    
    private synchronized static void clearExpired( int currentLimit ) {
    	ArrayList<Topic> allTopics = new ArrayList<Topic>();
    	allTopics = tli.getTopics();
    	int i;
        for (i=0; i < allTopics.size(); i++) {
        	Topic currentTopic = allTopics.get(i);
        	currentTopic.clearExpired(currentLimit);
        }
    }
    
    private synchronized static void clearAll(){
    	ArrayList<Topic> allTopics = new ArrayList<Topic>();
    	allTopics = tli.getTopics();
    	int i;
        for (i=0; i < allTopics.size(); i++){
        	Topic currentTopic = allTopics.get(i);
        	currentTopic.clearAll();
        }
    }
    
    
    public static void main(String[] args) {
        Socket s;
        Thread t;
        Thread timerThread;
        Timer timer = new Timer(30);
        
        try {
        	// start a new timer thread
        	timerThread = new Thread( timer );
            timerThread.start();
            
            ss = new ServerSocket(PORT);

            while(true) {
                s = ss.accept();

                // Send both the TopicInterface and MessageQueueInterface to the client;
                // he will decide if he is going to send a Post or a Message
              
                Client c1 = new Client(s, tli, mqi);
                t = new Thread(c1);
                t.start();
                
                // delete all expired posts from all topics
                clearExpired(timer.getCurrentLimit());
                
                // if time ran out, delete all posts
                if(!timerThread.isAlive())
                	clearAll();
                
            }
        } catch (SocketException e) {
            System.exit(1);
        } catch (IOException e){
            System.exit(1);
        } finally {
            if (ss != null) {
                try{
                    ss.close();
                } catch (Exception e)  {
                    System.exit(1);
                }
            }
        }
    }
}