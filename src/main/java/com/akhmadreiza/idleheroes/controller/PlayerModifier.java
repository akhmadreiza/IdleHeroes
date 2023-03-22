/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.entities.Player;
import com.akhmadreiza.idleheroes.entities.PlayerJobNovice;
import com.akhmadreiza.idleheroes.entities.PlayerJobWarrior;
import com.akhmadreiza.idleheroes.exception.FeatureUnimplementedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.akhmadreiza.idleheroes.Utils.print;
import static com.akhmadreiza.idleheroes.Utils.println;

/**
 * @author akhmadreiza
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModifier {

    private int playerHP;
    private int playerMinAtk;
    private int playerMaxAtk;
    private String playerJob;
    private String playerName;
    private int playerExp;
    private int playerLevel;
    private List playerItemName;
    private List playerItemQty;
    private StateEnum prevState;
    private StateEnum nextState;

    public PlayerModifier(Player player) {
        if (this.playerItemName == null) {
            this.playerItemName = new ArrayList<>();
        }

        if (this.playerItemQty == null) {
            this.playerItemQty = new ArrayList<>();
        }

        if (player instanceof PlayerJobNovice) {
            PlayerJobNovice novice = new PlayerJobNovice();
            this.playerJob = novice.getJob();
            this.playerHP = novice.getHp();
            this.playerMaxAtk = novice.getMaxAtk();
            this.playerMinAtk = novice.getMinAtk();
            this.playerLevel = novice.getLevel();
        }
    }

    public void levelUp() {
        playerLevel = playerLevel + 1;
        playerExp = 0;
    }

    public void promote(Player player) {
        if (player instanceof PlayerJobWarrior) {
            PlayerJobWarrior warrior = new PlayerJobWarrior();
            this.playerJob = warrior.getJob();
            this.playerHP = warrior.getHp();
            this.playerMaxAtk = warrior.getMaxAtk();
            this.playerMinAtk = warrior.getMinAtk();
            this.playerLevel = warrior.getLevel();
            this.playerExp = warrior.getExp();
        } else {
            throw new FeatureUnimplementedException("Player Job not implemented yet");
        }
    }

    public void printStat() {
        println("==============================");
        println("Idle Heroes - Your Stats");
        println("==============================");

        println("");

        println("HP" + ":" + this.playerHP);
        println("Job" + ":" + this.playerJob);
        println("Level" + ":" + this.playerLevel);
        println("XP" + ":" + this.playerLevel);

        println("==============================");
    }
}
