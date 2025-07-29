package karinzz.spring.core.service;

import karinzz.spring.core.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  CategoryService {

    @Getter
    private CategoryRepository categoryRepository;

//    Penggunaan setter dependency injection:
    @Autowired // Autowired digunakan untuk menginjeksi dependency
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
