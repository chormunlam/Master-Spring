package com.chormun.learnspringframework.hellowworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Primary
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

    @Bean
    public Person person4qualifier(String name, int age, @Qualifier("address3qualifier")Address address)//name, age, addrs2
    {
        return new Person(name, age, address);
    }
    @Bean(name="address2")
    @Primary
    public  Address address(){
        return new Address("Baker st", "London");

    }
    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public  Address address3(){
        return new Address("b612", "b612");

    }

}
