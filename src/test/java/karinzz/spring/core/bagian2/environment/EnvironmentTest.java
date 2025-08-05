package karinzz.spring.core.bagian2.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * Environment tidak hanya bisa digunakan untuk mengakses Application Properties
 * Environment juga bisa digunakan untuk mengakses data environment variable pada sistem operasi
 */
@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    void testEnvironment() {
        String javaHome = environment.getProperty("JAVA_HOME");

        //lakukan test equal dengan hasil ini diterminal: env | grep JAVA_HOME
    }

    @SpringBootApplication
    public static class TestApplication{

    }
}
