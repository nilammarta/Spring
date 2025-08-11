package karinzz.spring.core.bagian4.data;

import karinzz.spring.core.bagian4.validation.Palindrome;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo3 {

    @Palindrome
    private String bar;
}
