package karinzz.spring.core;

import karinzz.spring.core.data.Bar;
import karinzz.spring.core.data.Foo;
import karinzz.spring.core.data.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses,
 * akan mengembalikan object yang sama. Untuk mengubah scope sebuah bean,
 * kita bisa tambahkan annotation @Scope(value=”namaScope”)
 */

@Slf4j
@Configuration
public class ScopeConfiguration {
    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Create NEW Foo");
        return new Foo();
    }

    // Menambahkan scope kustom untuk "Doubleton"
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope(value = "doubleton") // Menggunakan scope kustom "Doubleton"
    public Bar bar() {
        log.info("Create NEW Bar");
        return new Bar();
    }
}
