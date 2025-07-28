package karinzz.spring.core.data.cyclic;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server{

    @PostConstruct
    public void start() {
        log.info("Server started");
    }

    @PreDestroy
    public void stop() {
        log.info("Server stopped");
    }


    /**
     * jika mengimplementasi InitializingBean dan DisposableBean
     * maka perlu melakukan override method seperti dibawah ini
     */

//    @Override
//    public void destroy() throws Exception {
//        stop();
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        start();
//    }
}
