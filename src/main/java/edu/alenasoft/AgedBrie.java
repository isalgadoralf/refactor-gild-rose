package edu.alenasoft;

public class AgedBrie extends Item implements UpdateItem{
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void updateQuality() {
        if (quality < ConstansValue.MAX_QUALITY) {
            quality++;
        }
        sellIn++;
        if (sellIn < ConstansValue.MIN_QUALITY && quality < ConstansValue.MAX_QUALITY) {
            quality++;
        }
    }
}
