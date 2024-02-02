package bj.hecm.demospringconcepts.repositories;

import bj.hecm.demospringconcepts.entities.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
        create(new User("razaki", "razaki@gmail.com"));
        create(new User("said", "said@gmail.com"));
        create(new User("elfried", "elfried@gmail.com"));
        create(new User("dereck", "dereck@gmail.com"));
    }

    public Map<String, User> findAll() {
        return users;
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public void create(User user) {
        users.put(user.username(), user);
    }
}
