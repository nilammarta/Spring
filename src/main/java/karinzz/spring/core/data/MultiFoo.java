package karinzz.spring.core.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFoo {

    // misalnya ingin mengambil semua list foo
    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        // jika ingin mengambil satu saja dapat menggunakan
//        objectProvider.getIfAvailable();

        //jika ingin mengambil semua dapat menggunakan
        foos = objectProvider.stream().collect(Collectors.toList());
    }
}
