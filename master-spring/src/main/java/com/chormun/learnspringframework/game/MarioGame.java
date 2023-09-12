package com.chormun.learnspringframework.game;

public class MarioGame implements GamingConsole {
    public void up(){
        System.out.println("Jump");
    }

    public void down(){
        System.out.println("go into hole");
    }
    public void left(){
        System.out.println("go back");
    }
    public void right(){
        System.out.println("Accelrate");
    }
}
