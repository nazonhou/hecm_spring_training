package bj.hecm.demospringconcepts.services.impl;

import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;
import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import bj.hecm.demospringconcepts.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .build();

        User saved = userRepository.save(user);

        return new UserDto(saved.getEmail());
    }
}
