package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void SimpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator(){
        //given
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        //when
        String res = helloDecorator.sayHello("Test");
        //then
        assertThat(res).isEqualTo("*Test*");
    }
}
