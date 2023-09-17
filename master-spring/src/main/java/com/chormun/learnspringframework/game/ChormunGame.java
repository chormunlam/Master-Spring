package com.chormun.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ChormunGame implements GamingConsole{


    @Override
    public void up() {
        System.out.println("run up slide fast+1 banana");

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
