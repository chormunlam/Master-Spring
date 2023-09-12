package com.chormun.learnspringframework.hellowworld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        //1:launch a spring context-
        try (var context =
                     new AnnotationConfigApplicationContext(HellowWorldConfiguration.class)) {

            ;

            //2:configure the thing that we want spring to manage -@configuration
            //hellowowrld congiguratin -@configuration
            //name- @bean

            //3: restrieivng beans managed by Sprngn
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person4qualifier"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class) + "this is Address.class");
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameter"));
            System.out.println(context.getBean(Person.class) + "this is Pesrn.class");
            //sout
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }}