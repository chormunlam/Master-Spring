package com.chormun.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class ClassA{// classA using bean

}
@Component
@Lazy
class ClassB{ //classB using classA
    private ClassA classA;
    public ClassB(ClassA classA){
        //Logic
        System.out.println("some initializetion logic");
        this.classA=classA;
    }
    public void doSth(){
        System.out.println("do  sth ");
    }
}
@Configuration
@ComponentScan

public class LazyInitialiationLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(LazyInitialiationLaucherApp.class)) {
//            Arrays.stream(context.getBeanDefinitionNames())
//                    .forEach(System.out::println);
            //even the code above removed, the classB initaztion still auto performed. auto called.
            //to prevent it use Lazy.

            System.out.println("initializtion of context is compled");
            context.getBean(ClassB.class).doSth();// now the bean loaded, make use, now:
//            initializtion of context is compled
//            some initializetion logic
//            do  sth

        }

    }
}
