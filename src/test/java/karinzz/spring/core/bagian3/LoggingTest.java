package karinzz.spring.core.bagian3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class LoggingTest {

    // untuk saat ini di set level log nya yaitu pada warn, shingga untuk info tidak bisa di tampilkan
    @Test
    void testLog(){
        log.info("Belajar Java");
        log.warn("Belajar Spring");
        log.error("Belajar Programmer Zaman Now");
    }

    @Test
    void testLongLogging(){
        for (int i = 0; i < 100; i++) {
            log.warn("Hello World {}", i);
        }
    }
}
