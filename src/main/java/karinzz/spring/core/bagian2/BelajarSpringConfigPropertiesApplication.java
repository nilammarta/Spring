package karinzz.spring.core.bagian2;

import karinzz.spring.core.bagian2.converter.StringToDateConverter;
import karinzz.spring.core.bagian2.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
    ApplicationProperties.class
})
public class BelajarSpringConfigPropertiesApplication {

    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
        ApplicationConversionService conversionService = new ApplicationConversionService();
        conversionService.addConverter(stringToDateConverter);
        return conversionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
    }
}
