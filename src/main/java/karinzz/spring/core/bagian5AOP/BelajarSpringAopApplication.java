package karinzz.spring.core.bagian5AOP;

import karinzz.spring.core.bagian2.BelajarSpringConfigPropertiesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// UNTUK MENGAKTIFKAN AOP, PERLU MENAMBAHKAN ANNOTASI @EnableAspectJAutoProxy pada KELAS UTAMA APLIKASI
@EnableAspectJAutoProxy
@SpringBootApplication
public class BelajarSpringAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
    }
}
