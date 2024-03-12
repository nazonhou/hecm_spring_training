package bj.hecm.demospringconcepts.services.impl;

import bj.hecm.demospringconcepts.dto.UserDto;
import bj.hecm.demospringconcepts.dto.requests.CreateUserRequest;
import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private UserServiceImpl userService;
    private UserRepository userRepository;
    private CreateUserRequest request;
    private User user;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);

        request = CreateUserRequest.builder()
                .email("johndoe@gmail.com")
                .username("johnDoe")
                .build();

        user = User.builder()
                .username(request.username())
                .email(request.email())
                .build();

        when(
                userRepository.save(eq(user))
        )
                .thenReturn(user);

        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void getUserDtoWhenUserIsCreated() {
        // Context

        // Action
        UserDto result = userService.createUser(request);

        // Assertions
        Assertions.assertThat(result.email()).isEqualTo("johndoe@gmail.com");

        verify(userRepository, times(1)).save(eq(user));
    }
}