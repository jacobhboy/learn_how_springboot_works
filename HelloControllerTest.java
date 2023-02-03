package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.BasicJsonTester;

public class HelloControllerTest {
    @Test
    void helloController(){
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController(){
        //given
        HelloController helloController = new HelloController(name -> name);
        //then
        Assertions.assertThatThrownBy(()->{
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->{
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
