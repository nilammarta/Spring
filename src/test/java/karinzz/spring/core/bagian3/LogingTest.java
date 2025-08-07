package karinzz.spring.core.bagian3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LogingTest {

    @Test
    void testLog(){
        log.info("Belajar Java");
        log.warn("Belajar Spring");
        log.error("Belajar Programmer Zaman Now");
    }
}
