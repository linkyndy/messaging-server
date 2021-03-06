package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pack.Post;
import pack.Topic;

public class TopicList {
    private ArrayList<Topic> topics;

    TopicList() {
        this.topics = new ArrayList<Topic>();
    }

    public ArrayList<Topic> getTopics() {
        return this.topics;
    }

    public String addTopic(String title, int id) {
        Topic topic = new Topic(title, id);

        if (!this.topics.contains(topic)) {
            this.topics.add(topic);
            return "Topic added successfully";
        }

        return "This topic has already been introduced.";
        
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

    public String addPost(int topic_id, String text, int expires) {
        int i;
        for (i = 0; i < this.topics.size(); i++) {
            if (this.topics.get(i).getTopicID() == topic_id) {
                this.topics.get(i).addPost(text, expires);
                return "Post added successfully";
            }
        }

        return  "This topic does not exist in the list.";
    }

}