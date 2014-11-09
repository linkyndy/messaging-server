package pack;

import java.util.ArrayList;
import java.util.List;

import pack.Message;

public class MessageQueue {
    private List<Message> messages;
    private int limit;
    private int length = 0;

    MessageQueue(int limit) {
        this.messages = new List<Message>();
        this.limit = limit;
    }

    public boolean push(String text, String receiver) {
        if (this.messages.size() < this.limit) {
            Message message = new Message(text, receiver);
            this.messages.add(message);
            return true;
        }
        return false;
    }

    public Message pop(String receiver) {
        if (this.messages.size() > 0) {
            Message firstMessage = this.messages.get(0);
            if (firstMessage.getReceiver().equals(receiver)) {
                this.messages.remove(0);
                return firstMessage;
            }
        }
        return null;
    }
}
