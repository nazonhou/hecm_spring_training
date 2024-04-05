package bj.hecm.demospringconcepts.repositories;

import bj.hecm.demospringconcepts.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:16.2-alpine:///demoSpringConcepts"
})
class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void test() {
        testEntityManager.persistAndFlush(
                User.builder()
                        .createdAt(LocalDateTime.parse("2023-01-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                        .email("razaki@gmail.com")
                        .username("razaki")
                        .build()
        );

        testEntityManager.persistAndFlush(
                User.builder()
                        .createdAt(LocalDateTime.parse("2024-01-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                        .email("dereck@gmail.com")
                        .username("dereck")
                        .build()
        );

        testEntityManager.persistAndFlush(
                User.builder()
                        .createdAt(LocalDateTime.parse("2024-04-05 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                        .email("elfried@gmail.com")
                        .username("elfried")
                        .build()
        );

        List<User> results = userRepository.getAllUsers(
                LocalDateTime.parse("2024-01-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2024-04-05 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                PageRequest.of(0, 1)
        );

        assertThat(results.size()).isEqualTo(2);
    }
}