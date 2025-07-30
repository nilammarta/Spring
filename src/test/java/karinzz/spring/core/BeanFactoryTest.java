package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        // menggunakan AnnotationConfigApplicationContext untuk menginisialisasi konteks aplikasi
        // yaitu menggunkana ScanConfiguration
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

     @Test
    void testBeanFactory() {
         ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
         List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());

         System.out.println(fooList);

         // untuk mengetahui nama beans nya dapat menggunakan cara berikut:
         Map<String, Foo> beans = applicationContext.getBeansOfType(Foo.class);
         System.out.println(beans);
    }
}
