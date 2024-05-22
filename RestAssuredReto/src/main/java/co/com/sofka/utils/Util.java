package co.com.sofka.utils;

import co.com.sofka.models.Post;

public class Util {
    public static Post crearPost(){
        Post post = new Post();
        post.setBody("quia et suscipit nsuscipit recusandae consequuntur expedita et cum nreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto");
        post.setUserId(2);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        return post;
    }
}
