package edu.alenasoft;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String CONJURED = "Conjured Mana Cake";

  public static final int MAX_QUALITY = 50;
  public static final int MIN_QUALITY = 0;


  public static List<Item> items = null;

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();

    System.out.println(items);
  }

  public static void updateQuality() {
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
