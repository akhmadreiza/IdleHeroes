/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;
import com.akhmadreiza.idleheroes.items.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author akhmadreiza
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonsterModifier {

    private String monsterName;
    private int monsterAtk;
    private int monsterHP;
    private int monsterMinAtk;
    private int monsterMaxAtk;
    private String monsterClass;
    private int monsterExp;
    private int monsterLevel;
    private List<Item> monsterDrops;

    public MonsterModifier(Monster monster) {
        if (monster instanceof MonsterRabbit) {
            MonsterRabbit rbt = (MonsterRabbit) monster;
            this.monsterName = rbt.getName();
            this.monsterClass = rbt.getClazz();
            this.monsterHP = rbt.getHp();
            this.monsterMinAtk = rbt.getMinAtk();
            this.monsterMaxAtk = rbt.getMaxAtk();
            this.monsterExp = rbt.getStoredExp();
            this.monsterLevel = rbt.getLevel();
            this.monsterDrops = rbt.getDrops();
        }
    }

    public void printMonsterDrops() {
        monsterDrops.forEach(item -> {
            Utils.print(item.getName() + " (" + item.getQty() + ") ");
        });
    }
}
