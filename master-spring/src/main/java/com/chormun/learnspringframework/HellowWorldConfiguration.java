package com.chormun.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
record Person(String name, int age ){ };
record Address(String firstLine, String city){};
@Configuration
public class HellowWorldConfiguration {
    @Bean
    public String name(){
        return "Chormun";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("bobo", 5);

    }
    @Bean
    public  Address address(){
        return new Address("Baker st", "London");

    }

}
