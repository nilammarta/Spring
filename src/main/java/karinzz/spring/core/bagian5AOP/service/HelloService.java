package karinzz.spring.core.bagian5AOP.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloService {
    // CONTOH SERVICE TANPA MENGGUNAKAN AOP
    public String hello(String name) {
        log.info("Call HelloService.hello()");
        return "Hello " + name;
    }

    public String hello(String firstName, String lastName) {
        log.info("Call HelloService.hello() with greeting");
        return "Hello2 " + firstName + " " + lastName;
    }

    public String bye(String name) {
        log.info("Call HelloService.bye()");
        return "Bye " + name;
    }

    public void test(){
        log.info("Call HelloService.test()");
    }

}
