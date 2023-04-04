package com.akhmadreiza.idleheroes.items;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Consumable extends Item {
    private int healPoint;
}
