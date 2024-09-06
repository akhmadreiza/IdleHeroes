package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;
import com.akhmadreiza.idleheroes.entities.MonsterSpyda;
import lombok.Getter;

import static com.akhmadreiza.idleheroes.Utils.getRandBetweenInt;

@Getter
public class Playground implements Biome {
    @Override
    public Monster determineEnemyEncounter() {
        int chance = getRandBetweenInt(1, 100);
        if (chance <= 80) {
            //number between 1 - 80 (80% chance)
            return new MonsterRabbit();
        } else if (chance <= 95) {
            //number between 81 - 95 (15% chance)
            return new MonsterRabbit();
        } else {
            //(5% chance)
            return new MonsterSpyda();
        }
    }

    @Override
    public String getBiomeName() {
        return Biomes.PLAYGROUND.name();
    }
}
