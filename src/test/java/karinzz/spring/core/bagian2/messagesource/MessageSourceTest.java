package karinzz.spring.core.bagian2.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    private ApplicationContext applicationContext;

    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @Test
    void testDefaultMessageSource() {
        // Mengambil pesan dari file my.properties
        String message = messageSource.getMessage("hello", new Object[]{"Kiki"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Kiki", message);
        System.out.println(message);
    }

    @Test
    void testIndonesianMessageSource() {
        // Mengambil pesan dari file my.properties
        String message = messageSource.getMessage("hello", new Object[]{"Kiki"}, new Locale("id", "ID"));
        Assertions.assertEquals("Halo Kiki", message);
        System.out.println(message);
    }

    @SpringBootApplication
    public static class TestApplication{

        @Bean
        public MessageSource messageSource(){
            // Melakukan pengambilan pesan dari file my.properties
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            // untuk set data dari file my.properties dengan menyebutkan nama file yaitu "my"
            messageSource.setBasenames("my");
            return messageSource;
        }
    }


}
