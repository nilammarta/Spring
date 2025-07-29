package karinzz.spring.core;

import karinzz.spring.core.configuration.BarConfiguration;
import karinzz.spring.core.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// Untuk mengambil configuration lain, dapat menggunakan @Import
@Import({
        FooConfiguration.class,
        BarConfiguration.class,
})
public class MainConfiguration {

}
