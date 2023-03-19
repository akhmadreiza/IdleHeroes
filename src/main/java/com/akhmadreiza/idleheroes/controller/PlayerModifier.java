/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.entities.Player;
import com.akhmadreiza.idleheroes.entities.PlayerJobNovice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
        if (player instanceof PlayerJobNovice) {
            PlayerJobNovice novice = new PlayerJobNovice();
            this.playerJob = novice.getJob();
            this.playerHP = novice.getHp();
            this.playerMaxAtk = novice.getMaxAtk();
            this.playerMinAtk = novice.getMinAtk();
            this.playerLevel = novice.getLevel();
            this.playerItemName = new ArrayList<>();
            this.playerItemQty = new ArrayList<>();
        }
    }

    public void levelUp() {
        playerLevel = playerLevel + 1;
        playerExp = 0;
    }
}
