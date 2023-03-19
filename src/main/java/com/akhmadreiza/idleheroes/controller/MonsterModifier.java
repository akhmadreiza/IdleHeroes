/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

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
    private List monsterDropItem;
    private List monsterDropQty;

}
