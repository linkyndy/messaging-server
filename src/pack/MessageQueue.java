package pack;

import java.util.ArrayList;
import java.util.List;

import pack.Message;

public class MessageQueue {
    private List<Message> messages;
    private int limit;

    MessageQueue(int limit) {
        this.messages = new ArrayList<Message>();
        this.limit = limit;
    }

    public String push(String text, String receiver) {
        if (this.messages.size() < this.limit) {
            Message message = new Message(text, receiver);
            this.messages.add(message);
            return "Message <" + message + "> added successfully";
        }
        return "Message <" + text  + ";" + receiver + "> could not be added";
    }

    public String pop(String receiver) {
        if (this.messages.size() > 0) {
            Message firstMessage = this.messages.get(0);
            if (firstMessage.getReceiver().equals(receiver)) {
                this.messages.remove(0);
                return firstMessage.toString();
            }
        }
        return null;
    }
 
}