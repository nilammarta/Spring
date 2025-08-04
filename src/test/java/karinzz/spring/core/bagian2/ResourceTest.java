package karinzz.spring.core.bagian2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {

    @Test
    void testResource() throws IOException {
//        cara mengambil resource dengan classpath
        var resource = new ClassPathResource("/text/sample.txt");

        Assertions.assertNotNull(resource);

        // bisa juga ngecek apakah ada atau tidak file tersebut
//        resource.exists();

        Assertions.assertTrue(resource.exists());
        Assertions.assertNotNull(resource.getFile());
    }
}
