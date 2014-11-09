package pack;

import pack.MessageQueue;

class MessageQueueInterface {
    // Single instance holding posted messages
    private static final MessageQueue mq;

    MessageQueueInterface(int limit) {
        this.mq = new MessageQueue(limit);
    }

    public synchronized boolean push(String title, String receiver) {
        /*
        Calls push on MessageQueue
        */
    }

    public synchronized boolean pop(String receiver) {
        /*
        Calls pop on MessageQueue
        */
    }
}
