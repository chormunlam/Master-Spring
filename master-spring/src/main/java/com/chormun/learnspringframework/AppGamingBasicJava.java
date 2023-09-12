package com.chormun.learnspringframework;

import com.chormun.learnspringframework.game.GameRunner;
import com.chormun.learnspringframework.game.MarioGame;
import com.chormun.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args){
        //var marioGame =new MarioGame();
        var superContraGame = new SuperContraGame();
        var gameRunner =new GameRunner(marioGame);
        gameRunner.run();
    }
}
