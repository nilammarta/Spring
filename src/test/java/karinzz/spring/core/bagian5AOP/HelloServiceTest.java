package karinzz.spring.core.bagian5AOP;

import karinzz.spring.core.bagian5AOP.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("Hello Karin", helloService.hello("Karin"));
        Assertions.assertEquals("Bye Karin", helloService.bye("Karin"));
    }
}
