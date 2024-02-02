package bj.hecm.demospringconcepts.services;

import org.springframework.stereotype.Component;

@Component
public class KkiaPay {
    public void pay(int amount) {
        System.out.println("Pay " + amount + " via KkiaPay service");
    }
}
