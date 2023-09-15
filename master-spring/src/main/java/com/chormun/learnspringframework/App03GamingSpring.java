package com.chormun.learnspringframework;

import com.chormun.learnspringframework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.chormun.learnspringframework.game.ChormunGame;
import com.chormun.learnspringframework.game.GameRunner;
import com.chormun.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GamingConfig {
    @Bean
    public GamingConsole game(){
        var game= new ChormunGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }




}


public class App03GamingSpring {
    public static void main(String[] args){
       //1: create congig file and bean
        //context
        try(var context=new AnnotationConfigApplicationContext(GamingConfig.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
