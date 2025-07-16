package karinzz.spring.core;
import karinzz.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// KONSEP BEAN DI SPRING
// Bean adalah objek yang dikelola oleh Spring IoC Container.
// Bean dapat berupa komponen, layanan, atau objek lain yang diperlukan dalam aplikasi.

@Slf4j
@Configuration
public class BeanConfiguration {

    // Di sini Anda dapat mendefinisikan bean dengan anotasi @Bean
    // atau menggunakan metode lain untuk mengonfigurasi bean.


//    untuk membuat Ben perlu dia buatkan method dengan return value object dari class yang dibuat, misalnya Foo
    @Bean
    public Foo foo() {
        Foo foo = new Foo();
        log.info(" create new Foo");
        return foo;
    }
}
