package karinzz.spring.core.processor;

import karinzz.spring.core.data.Foo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * Secara default, mungkin kita tidak akan pernah sama sekali membuat Application Context secara manual
 * Namun kadang ada keadaan kita ingin memodifikasi secara internal Application Context
 * Spring merekomendasikan kita untuk membuat Bean Factory Post Processor
 */

@Component
public class FooBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setScope("singleton");
        definition.setBeanClass(Foo.class);

        // Kita bisa menambahkan/meregistrasikan bean ke application context
        registry.registerBeanDefinition("foo", definition);
    }
}
