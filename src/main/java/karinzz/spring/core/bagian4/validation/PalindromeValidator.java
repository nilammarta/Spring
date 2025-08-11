package karinzz.spring.core.bagian4.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import karinzz.spring.core.bagian4.helper.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Validator untuk mengecek apakah sebuah string adalah palindrome.
 * Palindrome adalah string yang sama jika dibaca dari depan maupun belakang.
 */
public class PalindromeValidator implements ConstraintValidator<Palindrome, String> {

    @Autowired
    private StringHelper stringHelper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return stringHelper.isPalindrome(value);
    }
}
