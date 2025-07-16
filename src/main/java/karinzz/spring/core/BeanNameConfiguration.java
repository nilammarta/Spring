package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class BeanNameConfiguration {
    @Primary
    @Bean(name = "fooFirst")
    public Foo foo1(){
        return new Foo();
    }

    @Bean(name = "fooSecond")
    public Foo foo2(){
        return new Foo();
    }
}
