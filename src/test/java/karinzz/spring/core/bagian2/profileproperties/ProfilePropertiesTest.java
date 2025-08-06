package karinzz.spring.core.bagian2.profileproperties;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;


/**
 * FILE ini akan memuat profile properties
 * Saat kita menggunakan fitur profile, kita juga bisa membuat file properties sesuai dengan profile yang aktif
 * Penamaan properties file adalah application-{profile}.properties
 * Misal jika active profile adalah dev, maka application-dev.properties akan di load
 */
@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
// ini kaan menambahkan profile yang akan digunakan pada saat testing
// yaitu application-test.properties yang ada pada resources dan application-production.properties
@ActiveProfiles({"production", "test"})
public class ProfilePropertiesTest {

    @Autowired
    private TestApplication.ProfileProperties properties;

    @Test
    void nameProfileProperties() {
        // Menggunakan profile default
        System.out.println("Default File: " + properties.getDefaultFile());
        // Menggunakan profile production
        System.out.println("Production File: " + properties.getProductionFile());
        // Menggunakan profile test
        System.out.println("Test File: " + properties.getTestFile());

        Assertions.assertEquals("Default", properties.getDefaultFile());
        Assertions.assertEquals("Production", properties.getProductionFile());
        Assertions.assertEquals("Test", properties.getTestFile());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class ProfileProperties{
            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.production}")
            private String productionFile;

            @Value("${profile.test}")
            private String testFile;
        }
    }
}
