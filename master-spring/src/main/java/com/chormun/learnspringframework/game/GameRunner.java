package com.chormun.learnspringframework.game;

public class GameRunner {
    MarioGame game;
    public GameRunner(MarioGame game) {
        this.game=game;
    }

    public void run() {
        System.out.println("runiing game: " + game);
        game.up();
        game.down();
    }
}
