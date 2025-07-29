package karinzz.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * ScanConfiguration digunakan untuk melakukan scan pada package tertentu,
 * Sehingga Spring dapat menemukan komponen-komponen yang ada di dalamnya dan tidak perlu melakukan Import lagi.
 */
@ComponentScan(basePackages = {
        "karinzz.spring.core.configuration",
})
public class ScanConfiguration {

}
