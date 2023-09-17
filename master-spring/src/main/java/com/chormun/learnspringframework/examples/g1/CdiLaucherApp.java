package com.chormun.learnspringframework.examples.g1;


import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
//@Component
@Named
class BusinessService{
    private DataService dataService;


    public DataService getDataService() {
        System.out.println("setter injection performing ");
        return dataService;
    }
//    @Autowired
    //Injected
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }


}
@Component
class DataService{

}
@Configuration
@ComponentScan

public class CdiLaucherApp {

    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(CdiLaucherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());

        }



    }
}
