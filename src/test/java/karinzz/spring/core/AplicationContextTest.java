package karinzz.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// KONSEP TESTING DI SPRING
public class AplicationContextTest {
    @Test
    void testApplicationContext() {
        AplicationContextTest context = new AplicationContextTest();
        Assertions.assertNotNull(context, "Application context should not be null");
    }
}
