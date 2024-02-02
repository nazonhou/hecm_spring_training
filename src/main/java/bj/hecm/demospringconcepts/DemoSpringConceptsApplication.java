package bj.hecm.demospringconcepts;

import bj.hecm.demospringconcepts.services.CipGenerator;
import bj.hecm.demospringconcepts.services.FedaPay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoSpringConceptsApplication {

    public static void main(String[] args) {
        // Start the application && get the applicationContext
        ApplicationContext applicationContext = SpringApplication.run(DemoSpringConceptsApplication.class, args);
    }

}
