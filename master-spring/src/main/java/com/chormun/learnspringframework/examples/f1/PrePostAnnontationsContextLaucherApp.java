package com.chormun.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class SomeClass {
    private SomeDepdency someDepdency;
    public SomeClass(SomeDepdency someDepdency){
        super();
        this.someDepdency=someDepdency;
        System.out.println("all dep are ready");

    }
    //some logic
    public void initialize(){
        someDepdency.getready();
    }


}
@Component
class SomeDepdency{

    @PostConstruct //make this method invoke first
    public void getready() {
        System.out.println("some logic uisng some depencies");
    }

    @PreDestroy //sth need to do before terminate, clean up
    public void cheanup(){
        System.out.println("clean up");
    }
}
@Configuration
@ComponentScan

public class PrePostAnnontationsContextLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(PrePostAnnontationsContextLaucherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }

    }
}
// console:
//    some logic uisng some depencies
//        all dep are ready
//        org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//        org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//        org.springframework.context.annotation.internalCommonAnnotationProcessor
//        org.springframework.context.event.internalEventListenerProcessor
//        org.springframework.context.event.internalEventListenerFactory
//        prePostAnnontationsContextLaucherApp
//        someClass
//        someDepdency
//        clean up