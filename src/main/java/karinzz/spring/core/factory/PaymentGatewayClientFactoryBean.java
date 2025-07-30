package karinzz.spring.core.factory;

import karinzz.spring.core.client.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("paymentGatewayClient")
/**
 * Factory Bean adalah sebuah interface khusus yang memungkinkan Anda meng-custom pembuatan bean
 * secara lebih fleksibel dibanding cara biasa.
 * Dengan Factory Bean, Anda dapat mengontrol bagaimana bean dibuat,
 * misalnya dengan mengatur properti atau melakukan inisialisasi khusus sebelum bean digunakan.
 *
 * Pembuatan bean dengan Factory Bean ini akan dilakukan oleh Spring, dengan mengimplementasikan FactoryBean<T> interface.
 * dan mengoverride beberapa method seperti getObject() dan getObjectType().
 */
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {
    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("https://example.com");
        client.setPublicKey("public");
        client.setPrivateKey("private");
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
