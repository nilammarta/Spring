package karinzz.spring.core.bagian4.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Membuat annotation untuk validasi palindrome
 */

@Documented
@Constraint(validatedBy = {PalindromeValidator.class})
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface Palindrome {
    String message() default "{Palindrome.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
