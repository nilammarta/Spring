package karinzz.spring.core.service;

import karinzz.spring.core.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component merupakan salah satu stereotype annotation yang dapat digunakan untuk membuat bean di Spring.
 * dimana @Component akan membuat bean dengan nama yang sama dengan nama kelasnya, dengan aturan camel case.
 */
@Component
// disini juga bisa menambahkan scope, lazy, // dan lain-lain seperti pada @Bean
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    /**
     * @Autowired digunakan untuk melakukan dependency injection pada constructor. dan sebagai penanda jika
     * terdapat 2 constructor,
     * @param productRepository
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
    }
}
