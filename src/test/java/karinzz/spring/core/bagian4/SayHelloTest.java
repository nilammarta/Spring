package karinzz.spring.core.bagian4;

import jakarta.validation.ConstraintViolationException;
import karinzz.spring.core.bagian4.helper.SayHello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SayHelloTest {
    @Autowired
    private SayHello sayHello;

    @Test
    void testSuccess() {
        String result = sayHello.sayHello("Karinzz");
        System.out.println(result); // Expected output: Hello Karinzz

        Assertions.assertEquals("Hello Karinzz", result);
    }

    @Test
    void testError() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            sayHello.sayHello("");
        });
    }
}
