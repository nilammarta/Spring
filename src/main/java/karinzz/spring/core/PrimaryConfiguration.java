package karinzz.spring.core;

import karinzz.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryConfiguration {
// Menambahkan @Primary pada salah satu bean menjadikan bean tersebut prioritas utama dari bean dengan tipe yang sama,
// jika pasda saat mengakses object Foo saja tampan nama dari class foo maka tidak lagi terjadi error.
    @Primary
    @Bean
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }
}
