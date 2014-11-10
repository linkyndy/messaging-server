package pack;

import java.util.ArrayList;
import java.util.List;

import pack.Post;

public class Topic {
    private String title;
    private List<Post> posts;
    private int id;

    Topic(String title, int id) {
        this.title = title;
        this.id = id;
        this.posts = new ArrayList<Post>();
    }

    public int getTopicID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void addPost(String text, int expires) {
        Post post = new Post(text, expires);
        if (!this.posts.contains(post)) {
            this.posts.add(post);
        }
        else {
            System.out.print("This post has already been introduced.");
        }
    }
   
    
    /* remove all expired posts*/
    public void clearExpired(int currentLimit)
    {
    	int i;
    	for(i=0; i<this.posts.size(); i++)
    	{
    		Post currentPost = this.posts.get(i);
    		if(currentPost.getExpires() == currentLimit)
    		{
    			this.posts.remove(i);
    			i--;
    		}
    	}
    }
    
    public void clearAll()
    {
    	this.posts.clear();
    }
}