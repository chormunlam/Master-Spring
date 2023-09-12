package com.chormun.learnspringframework;

import com.chormun.learnspringframework.game.GameRunner;
import com.chormun.learnspringframework.game.MarioGame;
import com.chormun.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args){
        //var game =new MarioGame();
        var game = new SuperContraGame();
        var gameRunner =new GameRunner(game);
        gameRunner.run();
    }
}
