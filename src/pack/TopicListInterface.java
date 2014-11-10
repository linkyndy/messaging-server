package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



class TopicListInterface {
    // Single instance holding posted topics
    private static  TopicList tl;

    TopicListInterface() {
        this.tl = new TopicList();
    }

    public synchronized ArrayList<Topic>getTopics() {
        return this.tl.getTopics();
    }

    public synchronized boolean addTopic(String title, int id) {
        return this.tl.addTopic(title, id);
    }

    public synchronized List<Post> getPosts(int topic_id) {
        return this.tl.getPosts(topic_id);
    }

    public synchronized boolean addPost(int topic_id, String text, int expires) {
        return this.tl.addPost(topic_id, text, expires);
    }

}