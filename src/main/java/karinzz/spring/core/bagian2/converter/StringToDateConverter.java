package karinzz.spring.core.bagian2.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Konverter untuk mengubah String menjadi Date.
 * Format yang digunakan adalah "yyyy-MM-dd".
 *
 * Contoh penggunaan:
 * StringToDataConverter converter = new StringToDataConverter();
 * Date date = converter.convert("2023-10-01");
 */

@Component
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @SneakyThrows
    public Date convert(String source) {
        return DATE_FORMAT.parse(source);
    }
}
