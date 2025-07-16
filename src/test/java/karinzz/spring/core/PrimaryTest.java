package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {
    private ApplicationContext applicationContext;

    // Test untuk Primary Bean menggunakna @BeforeEach
    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);
    }

    @Test
    void testPrimary() {
//         karena sudah ada primary jadi tidak akan terjadi error, ketika ada dua bean dengan tipe yang sama (Foo).
       Foo foo = applicationContext.getBean(Foo.class);
//       atau bisa juga dilakukan dengan nama bean
       Foo foo1 = applicationContext.getBean("foo1", Foo.class);
       Foo foo2 = applicationContext.getBean("foo2", Foo.class);

       Assertions.assertSame(foo, foo1);
       Assertions.assertNotSame(foo, foo2);
       Assertions.assertNotSame(foo1, foo2);

    }
}
