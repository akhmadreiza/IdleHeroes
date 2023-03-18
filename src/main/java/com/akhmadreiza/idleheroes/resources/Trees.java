/**
 *
 */
package com.akhmadreiza.idleheroes.resources;

import com.akhmadreiza.idleheroes.biomes.Forest;

/**
 * @author akhmadreiza
 */
public class Trees extends Forest {

    private int maxWoodCount;

    @Override
    public int getTreeCounts() {
        // TODO Auto-generated method stub
        return 100;
    }

    public int getMaxWoodCount() {
        return getTreeCounts() * 5;
    }

    public void setMaxWoodCount(int maxWoodCount) {
        this.maxWoodCount = maxWoodCount;
    }
}
