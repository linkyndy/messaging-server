package pack;

import pack.TopicList;

class TopicListInterface {
    // Single instance holding posted topics
    private static final TopicList tl;

    TopicListInterface() {
        this.tl = new TopicList();
    }

    public synchronized String getTopics() {
        /*
        Calls getTopics on TopicList
        */
    }

    public synchronized boolean addTopic(String title) {
        /*
        Calls addTopic on TopicList
        */
    }

    public synchronized String getPosts(int topic_id) {
        /*
        Calls getPosts on TopicList
        */
    }

    public synchronized boolean addPost(String text, int topic_id, int expires) {
        /*
        Calls addPost on TopicList
        */
    }

    public synchronized boolean clearExpired() {
        /*
        Calls clearExpired on TopicList
        */
    }
}
