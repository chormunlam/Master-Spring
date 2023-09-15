package com.chormun.learnspringframework.examples.al;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//YourBusinessClass
@Component
class YourBusinessClass{

    Dep1 dep1;

    Dep2 dep2;


//    @Autowired
//    public void setDep1(Dep1 dep1) {
//        System.out.println("Settin Inject -setDep1: " );
//        this.dep1 = dep1;
//    }
//
//
//    @Autowired
//    public void setDep2(Dep2 dep2) {
//        System.out.println("Settin Inject -setDep2: " );
//        this.dep2 = dep2;
//    }

    public YourBusinessClass(Dep1 dep1, Dep2 dep2) {
        super();
        System.out.println("Constructor injecction - YourbusinessClss ");
        this.dep1 = dep1;
        this.dep2 = dep2;
    }

    public String toString(){
        return "Using " +dep1 +" and " + dep2;
    }

}
//Dependency1
@Component
class Dep1 {

}
//Dependency2
@Component
class Dep2{}

@Configuration
@ComponentScan

public class DepInjectionLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(DepInjectionLaucherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));


        }

    }
}
