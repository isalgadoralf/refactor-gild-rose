package edu.alenasoft;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class GildedRoseNewItemTest {

  @Test
  public void testConjuredDecrementQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 20;
    Item item = new Item("Conjured Mana Cake", 15, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality - 2;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testConjuredNonZeroQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 0;
    Item item = new Item("Conjured Mana Cake", 15, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 0;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testConjuredAlternativeNonZeroQuality() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 1;
    Item item = new Item("Conjured Mana Cake", 15, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 0;

    assertEquals(expectedQuality, item.getQuality());
  }


  @Test
  public void testConjuredQualityWhenSellInZero() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 10;
    Item item = new Item("Conjured Mana Cake", 0, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = inputQuality - 4;

    assertEquals(expectedQuality, item.getQuality());
  }

  @Test
  public void testConjuredAlternativeQualityWhenSellInZero() {
    // Contexto
    GildedRose.items = new ArrayList<>();
    int inputQuality = 3;
    Item item = new Item("Conjured Mana Cake", 0, inputQuality);

    GildedRose.items.add(item);
    GildedRose.updateQuality();

    int expectedQuality = 0;

    assertEquals(expectedQuality, item.getQuality());
  }
}
