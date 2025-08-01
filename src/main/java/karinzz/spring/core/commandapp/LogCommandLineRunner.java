package karinzz.spring.core.commandapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// component LogCommandLineRunner otomatis akan dideteksi oleh Spring Boot karena berada
// dalam satu package dengan CommandApplication
@Slf4j
@Component
public class LogCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Log Command Line Runner : {}", Arrays.toString(args));
    }
}
