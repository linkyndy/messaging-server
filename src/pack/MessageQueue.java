package pack;

import pack.Message;

public class MessageQueue {
    private List<Message> messages;
    private int limit;
    private int length = 0;

    MessageQueue(int limit) {
        this.messages = new List<Message>();
        this.limit = limit;
    }

    public void push(String text, String receiver) {
        /*
        Add message logic (append to this.messages a new Message object -- check
        if limit has not been exceeded)
        */
    }

    public void pop(String receiver) {
        /*
        Check if first message (this.messages[0]) has the receiver equal to
        given receiver; if yes, return the Message object and remove it from
        this.messages; if no, do nothing (wait for someone else to pick the
        first message)
        */
    }
}
