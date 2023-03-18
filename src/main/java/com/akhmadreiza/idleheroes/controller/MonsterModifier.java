/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import java.util.List;

/**
 * @author akhmadreiza
 */
public class MonsterModifier {

    private String monsterName;
    private int monsterAtk;
    private int monsterHP;
    private int monsterMinAtk;
    private int monsterMaxAtk;
    private String monsterClass;
    private int monsterExp;
    private int monsterLevel;
    private List monsterDropItem;
    private List monsterDropQty;

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterAtk() {
        return monsterAtk;
    }

    public void setMonsterAtk(int monsterAtk) {
        this.monsterAtk = monsterAtk;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public int getMonsterMinAtk() {
        return monsterMinAtk;
    }

    public void setMonsterMinAtk(int monsterMinAtk) {
        this.monsterMinAtk = monsterMinAtk;
    }

    public int getMonsterMaxAtk() {
        return monsterMaxAtk;
    }

    public void setMonsterMaxAtk(int monsterMaxAtk) {
        this.monsterMaxAtk = monsterMaxAtk;
    }

    public String getMonsterClass() {
        return monsterClass;
    }

    public void setMonsterClass(String monsterClass) {
        this.monsterClass = monsterClass;
    }

    public int getMonsterExp() {
        return monsterExp;
    }

    public void setMonsterExp(int monsterExp) {
        this.monsterExp = monsterExp;
    }

    public int getMonsterLevel() {
        return monsterLevel;
    }

    public void setMonsterLevel(int monsterLevel) {
        this.monsterLevel = monsterLevel;
    }

    public List getMonsterDropItem() {
        return monsterDropItem;
    }

    public void setMonsterDropItem(List monsterDropItem) {
        this.monsterDropItem = monsterDropItem;
    }

    public List getMonsterDropQty() {
        return monsterDropQty;
    }

    public void setMonsterDropQty(List monsterDropQty) {
        this.monsterDropQty = monsterDropQty;
    }
}
