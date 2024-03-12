package bj.hecm.demospringconcepts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTests {
    @Test
    void addTwoNumbers() {

        // Perform action
        int result = 1 + 2;

        // Assertions
        Assertions.assertThat(result).isEqualTo(3);
    }
}
