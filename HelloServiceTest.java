package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.BasicJsonTester;

import static org.assertj.core.api.Assertions.*;
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
