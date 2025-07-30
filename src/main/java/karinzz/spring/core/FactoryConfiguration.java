package karinzz.spring.core;

import karinzz.spring.core.client.PaymentGatewayClient;
import karinzz.spring.core.factory.PaymentGatewayClientFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
       PaymentGatewayClientFactoryBean.class
})
public class FactoryConfiguration {

}
