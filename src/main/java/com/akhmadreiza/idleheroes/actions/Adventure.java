package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;

import static com.akhmadreiza.idleheroes.Utils.*;
import static com.akhmadreiza.idleheroes.Utils.println;

public class Adventure {
    private PlayerModifier playerModifier;

    public Adventure(PlayerModifier playerModifier) {
        this.playerModifier = playerModifier;
    }

    public void begin() throws InterruptedException {
        playerModifier.setPrevState(StateEnum.ADVENTURE);
        clearScreen();

        println("=============================");
        println("Idle Heroes - Petualangan");
        println("==============================");

        println("Memulai petualangan.........");
        Thread.sleep(2000);

        int foo = getRandPercentage();
        if (foo < 60) //60% chance of meeting monster
        {
            playerModifier.setNextState(StateEnum.BATTLE);
            new Battle(playerModifier).begin();
        } else {
            //TODO if do not meet monster, give the player random resource
            playerModifier.setNextState(StateEnum.BACK_TO_BASE);
        }
    }
}
