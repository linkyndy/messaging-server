package pack;

import pack.MessageQueue;

class MessageQueueInterface {
    // Single instance holding posted messages
    private static MessageQueue mq;

    MessageQueueInterface(int limit) {
        this.mq = new MessageQueue(limit);
    }

    public synchronized String push(String title, String receiver) {
        return this.mq.push(title, receiver);
    }

    public synchronized String pop(String receiver) {
        return this.mq.pop(receiver);
    }
}