package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.entities.Monster;

public interface Biome {
    Monster determineEnemyEncounter();
    String getBiomeName();
}
