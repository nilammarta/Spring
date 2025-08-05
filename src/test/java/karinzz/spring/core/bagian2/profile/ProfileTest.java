package karinzz.spring.core.bagian2.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
// @ActiveProfiles anotasi ini digunakan untuk mengaktifkan semua test yang ada pada file pada profile tertentu
@ActiveProfiles({"production"})
public class ProfileTest {

    @Autowired
    private TestApplication.SayHello sayHello;

    @Test
    void testProfile() {
        Assertions.assertEquals("Hello Kiki from Local Profile", sayHello.say("Kiki"));
    }

    @SpringBootApplication
    public static class TestApplication {

        public interface SayHello {
            String say(String name);
        }


        @Component
        // Menambahkan @Profile local agar komponen ini hanya aktif pada profile local
        // yang di set pada file application.properties
        @Profile({"local"})
        public static class SayHelloLocal implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " from Local Profile";
            }
        }

        @Component
        @Profile({"production"})
        public static class SayHelloProduction implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " from Production Profile";
            }
        }
    }
}
