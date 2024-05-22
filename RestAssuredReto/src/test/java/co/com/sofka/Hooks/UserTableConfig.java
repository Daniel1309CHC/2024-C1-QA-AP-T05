package co.com.sofka.Hooks;

import co.com.sofka.models.User;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class UserTableConfig {
    @DataTableType
    public User user(Map<String, String> entry) {
        return new User(
                Integer.parseInt(entry.get("id")),
                entry.get("name"),
                entry.get("username"),
                entry.get("email"),
                entry.get("phone"),
                entry.get("website")
        );
    }
}
