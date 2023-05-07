package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;
import com.akhmadreiza.idleheroes.entities.MonsterSpyda;
import lombok.Getter;

@Getter
public class Playground {
    private final Monster monster;

    public Playground() {
        if (Utils.gotChance(80)) {
            this.monster = new MonsterRabbit();
        } else {
            this.monster = new MonsterSpyda();
        }
    }
}
