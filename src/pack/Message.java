package pack;

public class Message {
    private String text;
    private String receiver;

    Message(String text, String receiver) {
        this.text = text;
        this.receiver = receiver;
    }

    public String getReceiver() {
        return this.receiver;
    }
}
