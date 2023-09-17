package com.chormun.learnspringframework.examples.h1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

//@Configuration
@ComponentScan

public class XmlConfigContextLauncherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=
                    new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

        }

    }
}
