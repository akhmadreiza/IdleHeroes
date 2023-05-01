package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;
import com.akhmadreiza.idleheroes.entities.MonsterSpyda;
import lombok.Getter;

import static com.akhmadreiza.idleheroes.Utils.getRandPercentage;

@Getter
public class Playground {
    private final Monster monster;

    public Playground() {
        int randPercentage = getRandPercentage();
        if (randPercentage > 50) {
            this.monster = new MonsterRabbit();
        } else {
            this.monster = new MonsterSpyda();
        }
    }
}
