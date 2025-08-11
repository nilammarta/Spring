package karinzz.spring.core.bagian4.helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Melakukan validasi terhadap parameter yang diterima secara otomatis oleh Spring.
 */
@Component
public class SayHello implements ISayHello {

    public String sayHello(@NotBlank String name) {
        return "Hello " + name;
    }
}
