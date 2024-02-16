package bj.hecm.demospringconcepts;

import bj.hecm.demospringconcepts.entities.User;
import bj.hecm.demospringconcepts.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringConceptsApplication {

    public static void main(String[] args) {
        // Start the application && get the applicationContext
        ApplicationContext applicationContext = SpringApplication.run(DemoSpringConceptsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository
    ){
        return args -> {
            User user1 = User.builder()
                    .username("johnDoe")
                    .email("johndoe@gmail.com")
                    .build();
            userRepository.save(user1);
        };
    }

}
