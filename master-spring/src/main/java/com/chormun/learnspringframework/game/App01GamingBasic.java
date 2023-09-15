package com.chormun.learnspringframework.game;

import com.chormun.learnspringframework.game.ChormunGame;
import com.chormun.learnspringframework.game.GameRunner;
import com.chormun.learnspringframework.game.MarioGame;
import com.chormun.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {
    public static void main(String[] args){
        var game1 =new MarioGame();
        var game2 = new SuperContraGame();
        var game3 =new ChormunGame(); //1: object Creation
        var gameRunner =new GameRunner(game2);
        //2: Object Creation + wiring of Dependincy : the game is a dependency of gameRunner
        gameRunner.run();
    }
}
