package com.chormun.learnspringframework.game;

public class ChormunGame implements GamingConsole{


    @Override
    public void up() {
        System.out.println("run up slide banana");

    }

    @Override
    public void down() {
        System.out.println("go down with fly shoe");

    }

    @Override
    public void left() {
        System.out.println("go left help fd with popo");

    }

    @Override
    public void right() {
        System.out.println("go right chase the ememy");

    }
}