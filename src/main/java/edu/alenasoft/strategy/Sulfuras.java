package edu.alenasoft.strategy;

import edu.alenasoft.Item;

public class Sulfuras implements   UpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        // por la definicion del programa
        item.setSellIn(item.getSellIn()  -  1);
    }
}
