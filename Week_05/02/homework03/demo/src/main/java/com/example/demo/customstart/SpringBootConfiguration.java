package com.example.demo.customstart;

import com.example.demo.customstart.convert.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.customstart.convert")
public class SpringBootConfiguration {

    @Bean
    public User createUser()
    {
        return new User();
    }

}
