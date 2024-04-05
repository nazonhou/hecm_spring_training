package bj.hecm.demospringconcepts;

import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DemoSpringConceptsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringConceptsApplication.class, args);
    }

//    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository
    ){
        return args -> {
            User user1 = User.builder()
                    .username("johnDoe")
                    .email("johndoe@gmail.com")
                    .createdAt(LocalDateTime.parse("2023-01-01 00:00", DateTimeFormatter.ofPattern("")))
                    .build();
            userRepository.save(user1);
        };
    }

}
