package karinzz.spring.core;

import karinzz.spring.core.data.Bar;
import karinzz.spring.core.data.Foo;
import karinzz.spring.core.data.FooBar;
import org.junit.jupiter.api.Test;

public class DependencyInjectionTest {
    @Test
    void testNoID(){

        var foo = new Foo();
        var bar = new Bar();
        var fooBar = new FooBar(foo, bar);
    }
}
