package karinzz.spring.core;

import karinzz.spring.core.data.Bar;
import karinzz.spring.core.data.Foo;
import karinzz.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class OptionalConfiguration {
    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar bar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
