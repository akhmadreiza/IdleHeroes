/**
 *
 */
package com.ara.idleheroes.controller;

import java.util.List;

/**
 * @author akhmadreiza
 *
 */
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

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerMinAtk() {
        return playerMinAtk;
    }

    public void setPlayerMinAtk(int playerMinAtk) {
        this.playerMinAtk = playerMinAtk;
    }

    public int getPlayerMaxAtk() {
        return playerMaxAtk;
    }

    public void setPlayerMaxAtk(int playerMaxAtk) {
        this.playerMaxAtk = playerMaxAtk;
    }

    public String getPlayerJob() {
        return playerJob;
    }

    public void setPlayerJob(String playerJob) {
        this.playerJob = playerJob;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerExp() {
        return playerExp;
    }

    public void setPlayerExp(int playerExp) {
        this.playerExp = playerExp;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public List getPlayerItemName() {
        return playerItemName;
    }

    public void setPlayerItemName(List playerItemName) {
        this.playerItemName = playerItemName;
    }

    public List getPlayerItemQty() {
        return playerItemQty;
    }

    public void setPlayerItemQty(List playerItemQty) {
        this.playerItemQty = playerItemQty;
    }
}
