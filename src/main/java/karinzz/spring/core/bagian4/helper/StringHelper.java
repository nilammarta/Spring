package karinzz.spring.core.bagian4.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {

    // method untuk mengecek apakah sebuah string adalah palindrome
    public boolean isPalindrome(String value) {
       String reverse = new StringBuilder(value).reverse().toString();
       return value.equals(reverse);
    }
}
