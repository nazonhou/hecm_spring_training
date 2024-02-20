package bj.hecm.demospringconcepts.services;

import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log
class MathServiceTest {
    private MathService mathService;

    @BeforeEach
    void beforeEach() {
        mathService = new MathService();
    }

    @Test
    void get3WhenAdded1And2() {
        int result = mathService.addTwoNumbers(1, 2);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void get4WhenAdded2And2() {
        int result = mathService.addTwoNumbers(2, 2);
        Assertions.assertThat(result).isEqualTo(4);
    }
}