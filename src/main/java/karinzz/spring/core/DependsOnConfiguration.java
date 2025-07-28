package karinzz.spring.core;

import karinzz.spring.core.data.Bar;
import karinzz.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

/**
 * Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat,
 * Namun jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean lain dibuat,
 * dapat menggunakan annotation @DependsOn(value={”namaBean”})
 */

@Slf4j
@Configuration
public class DependsOnConfiguration {

    @Lazy // @Lazy digunakan untuk menunda pembuatan bean sampai benar-benar dibutuhkan
    @Bean
    @DependsOn("bar") // Foo akan dibuat setelah Bar dibuat
    public Foo foo() {
        log.info("Creating Foo bean");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("Creating Bar bean");
        return new Bar();
    }
}
