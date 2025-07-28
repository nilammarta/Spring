package karinzz.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicTest {
    @Test
    void testCyclic(){
       // ini akan terjadi error karena cyclic dependency
//        ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);

//        bisa dilakukan test seperti berikut:
        Assertions.assertThrows(Throwable.class, () -> {
            ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
            context.getBean("cyclicA", Object.class);
        });
    }
}
