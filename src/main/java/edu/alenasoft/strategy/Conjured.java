package edu.alenasoft.strategy;

import edu.alenasoft.ConstansValue;
import edu.alenasoft.Item;

public class Conjured implements UpdateStrategy {
    @Override
    public void updateQuality(Item item) {
//        if ( item.getQuality() > ConstansValue.MIN_QUALITY) {
//            item.setQuality(item.getQuality() -2);
//        }
//        item.setSellIn( item.getSellIn() -1 );
//        if (item.getSellIn() < ConstansValue.MIN_QUALITY &&   item.getQuality()  > ConstansValue.MIN_QUALITY) {
//            item.setQuality(item.getQuality() -2);
//        }
////        if ( item.getQuality() > ConstansValue.MIN_QUALITY) {
////            item.setQuality(item.getQuality() -1);
////            if (item.getSellIn() < ConstansValue.MIN_QUALITY){
////                item.setQuality(item.getQuality() -1);
////            }
////        }
        if ( item.getQuality() > ConstansValue.MIN_QUALITY) {
            int auxQuality = item.getQuality() - 2;
            if(auxQuality < ConstansValue.MIN_QUALITY ) {
                item.setQuality(ConstansValue.MIN_QUALITY);
            }else{
                item.setQuality(auxQuality);
            }
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < ConstansValue.MIN_QUALITY  && item.getQuality()  > ConstansValue.MIN_QUALITY ) {
            int auxQuality = item.getQuality() - 2;
            if(auxQuality < ConstansValue.MIN_QUALITY ) {
                item.setQuality(ConstansValue.MIN_QUALITY);
            }else{
                item.setQuality(auxQuality);
            }
        }
    }
}
