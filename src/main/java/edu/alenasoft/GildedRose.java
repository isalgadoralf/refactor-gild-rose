package edu.alenasoft;

import edu.alenasoft.strategy.UpdateStrategy;

import java.util.List;

public class GildedRose {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String CONJURED = "Conjured Mana Cake";

  public static final int MAX_QUALITY = 50;
  public static final int MIN_QUALITY = 0;


  public static List<Item> items ;

  private static final UpdateStrategy otherItemStrategy = new edu.alenasoft.strategy.OtherItem();
  private static final UpdateStrategy agedBrieStrategy = new edu.alenasoft.strategy.AgedBrie();
  private static final UpdateStrategy sulfurasStrategy = new edu.alenasoft.strategy.Sulfuras();
  private static final UpdateStrategy backstagePassStrategy = new edu.alenasoft.strategy.BackstagePasses();
  private static final UpdateStrategy conjuredItemStrategy = new edu.alenasoft.strategy.Conjured();

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items.add(new OtherItem("+5 Dexterity Vest", 10, 20));
    items.add(new AgedBrie("Aged Brie", 2, 0));
    items.add(new OtherItem("Elixir of the Mongoose", 5, 7));
    items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Conjured("Conjured Mana Cake", 3, 6));



    updateQuality();

    System.out.println(items);
  }
  public static void updateQuality() {
    for (Item item : items) {
      getUpdateStrategy(item).updateQuality(item);
    }

  }

  private static UpdateStrategy getUpdateStrategy(Item item) {
    switch (item.getName()) {
      case AGED_BRIE:
        return agedBrieStrategy;
      case SULFURAS:
        return sulfurasStrategy;
      case BACKSTAGE_PASSES:
        return backstagePassStrategy;
      case CONJURED:
        return conjuredItemStrategy;
      default:
        return otherItemStrategy;
    }
  }

  public static void updateQuality2() {
    for (int i = 0; i < items.size(); i++) {
      if ((!AGED_BRIE.equals(items.get(i).getName()))
          && !BACKSTAGE_PASSES.equals(items.get(i).getName())) {
        if (items.get(i).getQuality() > MIN_QUALITY) {
          if (!SULFURAS.equals(items.get(i).getName())) {
            items.get(i).setQuality(items.get(i).getQuality() - 1);
          }
        }
      } else {
        if (items.get(i).getQuality() < MAX_QUALITY) {
          items.get(i).setQuality(items.get(i).getQuality() + 1);

          if (BACKSTAGE_PASSES.equals(items.get(i).getName())) {
            if (items.get(i).getSellIn() < 11) {
              if (items.get(i).getQuality() < MAX_QUALITY) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }

            if (items.get(i).getSellIn() < 6) {
              if (items.get(i).getQuality() < MAX_QUALITY) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }
          }
        }
      }

      if (!SULFURAS.equals(items.get(i).getName())) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
      }

      if (items.get(i).getSellIn() < MIN_QUALITY) {
        if (!AGED_BRIE.equals(items.get(i).getName())) {
          if (!BACKSTAGE_PASSES.equals(items.get(i).getName())) {
            if (items.get(i).getQuality() > MIN_QUALITY) {
              if (!SULFURAS.equals(items.get(i).getName())) {
                items.get(i).setQuality(items.get(i).getQuality() - 1);
              }
            }
          } else {
            items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
          }
        } else {
          if (items.get(i).getQuality() < MAX_QUALITY) {
            items.get(i).setQuality(items.get(i).getQuality() + 1);
          }
        }
      }

      if (items.get(i).getName().equals(CONJURED)) {
        if (items.get(i).getQuality() > MIN_QUALITY) {
          items.get(i).setQuality(items.get(i).getQuality() - 1);
          if (items.get(i).getSellIn() < MIN_QUALITY) {
            items.get(i).setQuality(items.get(i).getQuality() - 1);
          }
        }
      }
    }
  }
}
