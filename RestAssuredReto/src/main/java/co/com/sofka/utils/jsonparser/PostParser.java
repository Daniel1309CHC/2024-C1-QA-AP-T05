package co.com.sofka.utils.jsonparser;

import co.com.sofka.models.Post;
import org.json.simple.JSONObject;

public class PostParser {

    public  static String postToJson(Post post) {
        // Crear un objeto JSONObject
        JSONObject jsonObject = new JSONObject();

        // Agregar los atributos del objeto Post al JSONObject
        jsonObject.put("title", post.getTitle());
        jsonObject.put("body", post.getBody());
        jsonObject.put("userId", post.getUserId());

        // Retornar el JSONObject resultante
        return jsonObject.toJSONString();
    }

    public static Post toPost(JSONObject jsonObject) {
        // Crear un objeto Post
        Post post = new Post();
        post.setId(Integer.parseInt(jsonObject.get("id").toString()));
        post.setTitle((String) jsonObject.get("title"));
        post.setBody((String) jsonObject.get("body"));
        post.setUserId(Integer.parseInt(jsonObject.get("userId").toString()));

        return post;
    }

}
