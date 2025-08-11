package karinzz.spring.core.bagian4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import karinzz.spring.core.bagian4.data.Foo3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class PalindromeTest {
    @Autowired
    private Validator validator;

    @Test
    void palindromeValid(){
        Set<ConstraintViolation<Foo3>> constraintViolations = validator.validate(new Foo3("kodok"));
        Assertions.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void palindromeInvalid(){
        Set<ConstraintViolation<Foo3>> constraintViolations = validator.validate(new Foo3("karin"));
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());
    }

    @Test
    void palindromeInvalidMessage(){
        Set<ConstraintViolation<Foo3>> constraintViolations = validator.validate(new Foo3("karin"));
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());

        String message = constraintViolations.stream().findFirst().get().getMessage();
        Assertions.assertEquals("Data bukan palindrome", message);
    }
}
