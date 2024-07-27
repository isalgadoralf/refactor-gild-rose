package edu.alenasoft;

public class Conjured extends Item implements UpdateItem{
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality > ConstansValue.MIN_QUALITY) {
            quality--;
        }
        sellIn--;
        if (sellIn < ConstansValue.MIN_QUALITY && quality > ConstansValue.MIN_QUALITY) {
            quality--;
        }
        if (quality > ConstansValue.MIN_QUALITY && sellIn < ConstansValue.MIN_QUALITY ) {
            quality-=2;
        }
    }
}
