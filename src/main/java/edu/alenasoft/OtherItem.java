package edu.alenasoft;

public class OtherItem extends Item implements UpdateItem{
    public OtherItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void updateQuality() {
        if (quality > ConstansValue.MIN_QUALITY) {
            quality--;
        }
        sellIn--;
        if (sellIn< ConstansValue.MIN_QUALITY && quality > ConstansValue.MIN_QUALITY) {
             quality--;
        }
    }
}
