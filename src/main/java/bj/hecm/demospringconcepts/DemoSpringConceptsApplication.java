package bj.hecm.demospringconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringConceptsApplication {

    public static void main(String[] args) {
        // Start the application && get the applicationContext
        ApplicationContext applicationContext = SpringApplication.run(DemoSpringConceptsApplication.class, args);
    }

}
