package com.chormun.learnspringframework;

import com.chormun.learnspringframework.game.ChormunGame;
import com.chormun.learnspringframework.game.GameRunner;
import com.chormun.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfig {
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
