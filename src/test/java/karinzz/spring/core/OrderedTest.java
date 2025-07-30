package karinzz.spring.core;

import karinzz.spring.core.data.Car;
import karinzz.spring.core.processor.IdGeneratorBeanPostProcessor;
import karinzz.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration {
        // This class can be used to define beans and configurations for testing purposes.
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = applicationContext.getBean(Car.class);
        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("PZN ="));
    }
}
