package com.chormun.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
record Person(String name, int age, Address address ){ };
record Address(String firstLine, String city){};
@Configuration
public class HellowWorldConfiguration {
    @Bean
    public String name(){
        return "Chormun";
    }

    @Bean
    public int age(){
        return 33;
    }

    @Bean
    public Person person(){
        return new Person("bobo", 5, new Address("live with mom", "NYC"));

    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(), address());
    }
    @Bean
    public Person person3Parameter(String name, int age, Address address3)//name, age, addrs2
    {
        return new Person(name, age, address3);
    }
    @Bean(name="address2")
    public  Address address(){
        return new Address("Baker st", "London");

    }
    @Bean(name="address3")
    public  Address address3(){
        return new Address("b612", "b612");

    }

}
