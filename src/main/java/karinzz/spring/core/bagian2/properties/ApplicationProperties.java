package karinzz.spring.core.bagian2.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Sebelum runfile ini pastikan sudah ada Folder di target/classes/META-INF/spring-configuration-metadata.json
 * dengan cara melakukan kompilasi memlalui maven dengan perintah: mvn clean compile
 *
 * dan pastikan juga pada file pom.xml sudah ada dependency:
 */

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

    private String name;

    private Integer version;

    private boolean productionMode;

    private DatabaseProperties database;

    private List<Role> defaultRoles;

    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties {
        private String username;
        private String password;
        private String database;
        private String url;
        // Contoh penggunaan List pada properties
        private List<String> whitelistTables;
        private Map<String, Integer> maxTableSize;
    }

    @Getter
    @Setter
    public static class Role {
        private String id;

        private String name;
    }

}
