package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterFatRabbit;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;
import com.akhmadreiza.idleheroes.entities.MonsterSpyda;

import static com.akhmadreiza.idleheroes.Utils.getRandBetweenInt;

public class Forest implements Biome {
    @Override
    public Monster determineEnemyEncounter() {
        int chance = getRandBetweenInt(1, 100);
        if (chance <= 55) {
            //number between 1 - 55 (55% chance)
            return new MonsterFatRabbit();
        } else if (chance <= 95) {
            //number between 56 - 95 (40% chance)
            return new MonsterRabbit();
        } else {
            //(5% chance)
            return new MonsterSpyda();
        }
    }

    @Override
    public String getBiomeName() {
        return Biomes.FOREST.name();
    }
}
