package karinzz.spring.core.bagian4;

import karinzz.spring.core.bagian2.BelajarSpringConfigPropertiesApplication;
import karinzz.spring.core.bagian4.properties.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        DatabaseProperties.class
})
@SpringBootApplication
public class BelajarSpringValidationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
    }
}
