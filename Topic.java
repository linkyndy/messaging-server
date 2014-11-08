import Post;

public class Topic {
    private String title;
    private List<Post> posts;
    private int length = 0;

    Topic(String title) {
        this.title = title
        this.posts = new List<Post>();
    }
}
