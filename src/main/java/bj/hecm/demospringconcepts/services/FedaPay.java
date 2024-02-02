package bj.hecm.demospringconcepts.services;

import org.springframework.stereotype.Component;

@Component
public class FedaPay {
    public void pay(int amount) {
        System.out.println("Pay " + amount + " via FedaPay service");
    }
}
