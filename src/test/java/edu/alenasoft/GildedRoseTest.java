package edu.alenasoft;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void testNormalItemDecrementQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("+5 Dexterity Vest", 10, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality - 1;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testNormalItemDoubleDecrementQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("+5 Dexterity Vest", 0, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality - 2;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testNormalItemZeroQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 0;
    Item item = new Item("+5 Dexterity Vest", 0, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 0;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testItemSufurasLegendary() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 80;
    Item item = new Item("Sulfuras, Hand of Ragnaros", 15, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 80;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testItemNoMayor50() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 50;
    Item item = new Item("Aged Brie", 20, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 50;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testbackstageIncrementsQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality + 1;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testbackstageDoubleIncrementQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality + 2;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testBackstageTripleIncrementQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality + 3;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testBackstageZeroQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 0;

    assertEquals(expectedQuality, item.getQuality());
  }
}
