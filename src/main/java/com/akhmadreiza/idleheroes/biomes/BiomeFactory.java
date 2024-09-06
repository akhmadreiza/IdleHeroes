package com.akhmadreiza.idleheroes.biomes;

import com.akhmadreiza.idleheroes.exception.FeatureUnimplementedException;

public class BiomeFactory {
    public static Biome generateBiome(Biomes biomes) {
        if (Biomes.PLAYGROUND.equals(biomes)) {
            return new Playground();
        } else if (Biomes.FOREST.equals(biomes)) {
            return new Forest();
        } else {
            throw new FeatureUnimplementedException("Biome not implemented yet");
        }
    }
}
