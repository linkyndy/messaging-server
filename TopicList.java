import Topic;
import Post;

public class TopicList {
    private List<Topic> topics;
    private int length = 0;

    TopicList() {
        this.topics = new List<Topic>();
    }

    public String getTopics() {
        /*
        Get topics logic (iterate over this.topics and return a String of all
        topic titles and their ids)
        */
    }

    public void addTopic(String title) {
        /*
        Add topic logic (append to this.topics a new Topic object)
        */
    }

    public void getPosts(int topic_id) {
        /*
        Get posts logic (search for topic with topic_id in this.topics, then
        iterate on found topic posts and return a String of all post texts)
        */
    }

    public void addPost(String text, int topic_id, int expires) {
        /*
        Add post to topic logic (search for topic with topic_id in this.topics
        and append to found topic a new Post object)
        */
    }

    public boolean clearExpired() {
        /*
        Clear expired posts logic (iterate over this.topics and each of their
        posts and remove expired posts)
        */
    }
}
