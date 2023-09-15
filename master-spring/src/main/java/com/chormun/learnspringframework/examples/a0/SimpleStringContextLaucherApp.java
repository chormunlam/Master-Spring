package com.chormun.learnspringframework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan

public class SimpleStringContextLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(SimpleStringContextLaucherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }

    }
}
