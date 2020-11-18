package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "helloSpring")
    HelloSpring02 helloSpring02()
    {
        return new HelloSpring02();
    }
}
