package edu.alenasoft.strategy;

import edu.alenasoft.ConstansValue;
import edu.alenasoft.Item;

public class OtherItem  implements UpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        if ( item.getQuality() > ConstansValue.MIN_QUALITY) {
            item.setQuality(item.getQuality() -1);
        }
        item.setSellIn( item.getSellIn() -1 );
        if (item.getSellIn() < ConstansValue.MIN_QUALITY &&   item.getQuality()  > ConstansValue.MIN_QUALITY) {
            item.setQuality(item.getQuality() -1);
        }
    }
}
