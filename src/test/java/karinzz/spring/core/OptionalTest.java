package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import karinzz.spring.core.data.FooBar;
import karinzz.spring.core.data.MultiFoo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void TestOptional(){
        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        // ini untuk mngecek apakah Bar tidak ada karena, karena tidak ada bean Bar yang didefinisikan
        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(fooBar.getFoo(), foo);
    }
}
