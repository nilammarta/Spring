package karinzz.spring.core.bagian2.configurationproperties;

import karinzz.spring.core.bagian2.converter.StringToDateConverter;
import karinzz.spring.core.bagian2.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private ConversionService conversionService;

    // melakukan test menggunakan conversion service
    @Test
    void testConversionService(){
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));
        Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));

        Duration result = conversionService.convert("10s", Duration.class);
        Assertions.assertEquals(Duration.ofSeconds(10), result);
    }

    @Test
    void testConfigurationProperties() {
        // Melakukan test terhadap ApplicationProperties
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }

    // Test untuk bagian database properties
    @Test
    void testDatabaseProperties() {
        // Melakukan test terhadap DatabaseProperties
        Assertions.assertEquals("kiki", properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", properties.getDatabase().getUrl());
    }

    // Test untuk bagian kompleksitas dari database properties
    @Test
    void testCollection(){
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("customers"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("categories"));
    }

    // Test untuk bagian collection configuration properties
    @Test
    void testEmbeddedCollection(){
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", properties.getRoles().get("finance").getName());
    }

    // Test untuk bagian convert duration configuration properties
    @Test
    void testDuration(){
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeout());
    }

    // melakukan test terhadap konverter yang mengubah String menjadi Date
    @Test
    void testCustomerConverter() {

        Date expiredDate = properties.getExpiredDate();

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals("2025-08-07", dateFormat.format(expiredDate));
    }

    @SpringBootApplication
    // bagian ini digunakan untuk mengaktifkan fitur auto configuration
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    @Import(StringToDateConverter.class)
    public static class TestApplication {


        // melakukan registrasi konverter StringToDateConverter ke dalam ConversionService
        //sehingga bisa digunakan untuk mengkonversi String menjadi Date
        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return  conversionService;
        }
    }
}
