package karinzz.spring.core.service;

import karinzz.spring.core.data.User;
import karinzz.spring.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Mengirimkan Event ke ApplicationEventPublisher
 */
@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Pada saat melakukan login, jika sukses akan mengirimkan event LoginSuccessEvent ke semua listener yang menggunakan event ini.
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        if (isLoginSuccess(username, password)) {
            // Mengirimkan event login sukses
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
            return true;
        } else {
          return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        return "karin".equals(username) && "karinzz".equals(password);
    }
}
