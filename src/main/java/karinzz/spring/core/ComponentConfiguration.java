package karinzz.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "karinzz.spring.core.service",
        "karinzz.spring.core.repository",
        "karinzz.spring.core.configuration",
})
public class ComponentConfiguration {

}
