package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {
    @Test
    void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

//        akan terjadi error karena ada 2 bean dengan tipe yang sama yaitu foo 1 dan foo 2
//        Foo foo = context.getBean(Foo.class);

//        mengecek apakah terjadi error NoUniqueBeanDefinitionException
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = context.getBean(Foo.class);
        });
    }

    @Test
//    untuk tetap mengakses bean, dapat dilakukan dengan nama dari methodnya
    void getBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
