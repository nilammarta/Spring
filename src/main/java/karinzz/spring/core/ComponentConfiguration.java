package karinzz.spring.core;

import karinzz.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "karinzz.spring.core.service",
        "karinzz.spring.core.repository",
        "karinzz.spring.core.configuration",
})
@Import(MultiFoo.class)
public class ComponentConfiguration {

}
