package co.com.sofka.utils.jsonparser;

import co.com.sofka.models.User;
import org.json.simple.JSONObject;

public class UserParser {

    public static User toUser(JSONObject jsonObject){
        // Crear un objeto User
        User user = new User();
        user.setId(Integer.parseInt(jsonObject.get("id").toString()));
        user.setName((String) jsonObject.get("name"));
        user.setUsername((String) jsonObject.get("username"));
        user.setEmail((String) jsonObject.get("email"));
        user.setPhone((String) jsonObject.get("phone"));
        user.setWebsite((String) jsonObject.get("website"));

        return user;
    }

}
