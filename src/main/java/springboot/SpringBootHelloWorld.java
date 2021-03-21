package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootHelloWorld implements CommandLineRunner {

    @Autowired
    HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorld.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloService.hello());
    }

    @Component
    public class HelloService {
        public String hello() {
            return "Hello world";
        }
    }

}
