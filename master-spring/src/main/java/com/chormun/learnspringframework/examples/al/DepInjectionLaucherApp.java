package com.chormun.learnspringframework.examples.al;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chormun.learnspringframework.examples.al")

public class DepInjectionLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(DepInjectionLaucherApp.class)) {

        }

    }
}
