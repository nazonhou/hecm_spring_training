package bj.hecm.demospringconcepts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CipGenerator {
    private int price = 10_000;
    private KkiaPay service;

    public CipGenerator(KkiaPay service) {
        this.service = service;
    }

    public void validateCipGeneration() {
        service.pay(price);
    }
}
