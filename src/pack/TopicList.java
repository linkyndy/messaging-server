package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pack.Post;
import pack.Topic;

public class TopicList {
    private List<Topic> topics;

    TopicList() {
        this.topics = new ArrayList<Topic>();
    }

    public HashMap<Integer, String> getTopics() {
        HashMap<Integer, String> allTopics = new HashMap<Integer, String>();

        int i;
        for (i = 0; i < this.topics.size(); i++) {
            int currentID = this.topics.get(i).getTopicID();
            String currentTitle = this.topics.get(i).getTitle();
            allTopics.put(currentID, currentTitle);
        }

        return allTopics;
    }

    public boolean addTopic(String title, int id) {
        Topic topic = new Topic(title, id);

        if (!this.topics.contains(topic)) {
            this.topics.add(topic);
            return true;
        }

        System.out.println("This topic has already been introduced.");
        return false;
    }

    public List<Post> getPosts(int topic_id) {
        int i;
        for (i = 0; i < this.topics.size(); i++) {
            if (this.topics.get(i).getTopicID() == topic_id) {
                return this.topics.get(i).getPosts();
            }
        }

        System.out.println("This topic does not exist in the list.");
        return null;
    }

    public boolean addPost(int topic_id, String text, int expires) {
        int i;
        for (i = 0; i < this.topics.size(); i++) {
            if (this.topics.get(i).getTopicID() == topic_id) {
                this.topics.get(i).addPost(text, expires);
                return true;
            }

        System.out.println("This topic does not exist in the list.");
        return false;
    }

    public void clearExpired( int currentLimit ) {
    	int i;
        for (i = 0; i < this.topics.size(); i++) {
        	Topic currentTopic = this.topics.get(i);
        	currentTopic.clearExpired(currentLimit);
        }
    }

    public void clearAll() {
    	int i;
        for (i = 0; i < this.topics.size(); i++) {
        	Topic currentTopic = this.topics.get(i);
        	currentTopic.clearAll();
        }
    }
}
