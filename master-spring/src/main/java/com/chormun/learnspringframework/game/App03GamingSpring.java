package com.chormun.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chormun.learnspringframework.game")

public class App03GamingSpring {
    //simpleir level 1: using component and Scan to fet this,
//    @Bean
//    public GamingConsole game(){
//        var game= new ChormunGame();
//        return game;
//    }
    //now we got component
    //level 2, let srpign do the runner for us
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        System.out.println("po po tan game: " + game);
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
    // also add the componat for runner.
    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(App03GamingSpring.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
