package karinzz.spring.core.bagian4.data;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    // ini merupaknan contoh validasi menggunakan Jakarta Bean Validation
    @NotBlank
    private  String id;
    @NotBlank
    private  String name;

}
