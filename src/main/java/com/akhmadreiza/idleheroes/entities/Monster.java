/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.items.Item;

import java.util.List;

/**
 * @author akhmadreiza
 */
public abstract class Monster {

    public abstract String getName();

    public abstract String getClazz();

    public abstract String getCode();

    public abstract int getHp();

    public abstract int getMinAtk();

    public abstract int getMaxAtk();

    public abstract int getStoredExp();

    public abstract int getLevel();

    public abstract List<Item> getDrops();
}
