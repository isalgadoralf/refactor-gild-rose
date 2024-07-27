package edu.alenasoft;

public class BackstagePasses extends Item implements UpdateItem{
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < ConstansValue.MAX_QUALITY) {
            quality++;
        }
        if (sellIn < 11 && quality < ConstansValue.MAX_QUALITY) {
            quality++;
        }

        if (sellIn < 6 && quality < ConstansValue.MAX_QUALITY ) {
            quality++;
        }
        sellIn--;
        if (sellIn < ConstansValue.MIN_QUALITY) {
            quality = 0;
        }
    }
}
