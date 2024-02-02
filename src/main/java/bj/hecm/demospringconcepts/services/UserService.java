package bj.hecm.demospringconcepts.services;

import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        Map<String, User> usersMap = userRepository.findAll();

        List<User> users = new ArrayList<>();

        usersMap.forEach((username, user) -> {
            users.add(user);
        });

        return users;
    }

    public User createUser(User user) {
        userRepository.create(user);
        return user;
    }
}
