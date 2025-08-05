package karinzz.spring.core.bagian2.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * Value merupakan Annotation yang bisa kita gunakan untuk melakukan inject data dari properties ke field yang kita tandai
 * Annotation Value bisa kita gunakan untuk mengambil data dari application properties
 * menggunakan kode ${nama.properties.nya}
 * Secara otomatis akan diambil valuenya, dan secara otomatis akan melakukan konversi juga
 */
@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties properties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    // Test ini tidak bisa dilakukan, karena JAVA_HOME tidak ada di application.properties
//    @Test
//    void testSystemProperties() {
//        // Test apakah JAVA_HOME sudah terisi
//        Assertions.assertNotNull(systemProperties.javaHome);
//        // Test apakah JAVA_HOME berisi string yang tidak kosong
//        Assertions.assertFalse(systemProperties.javaHome.isBlank());
//    }

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }



    @SpringBootApplication
    public static class TestApplication {

        // Component ini akan mengakses data dari environment variable menggunakan annotation Value
        @Component
        public static class  SystemProperties{
            @Value("${JAVA_HOME}")
            private String javaHome;
        }




        @Component
        @Getter
        public static class ApplicationProperties {
            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;

        }
    }
}
