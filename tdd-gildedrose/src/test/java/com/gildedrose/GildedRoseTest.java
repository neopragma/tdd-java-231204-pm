package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void conjuredManaCake_decreases_in_value_by_2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 6, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void backstagePasses_increases_in_value_by_2_when_less_than_10_days_to_go() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void backstagePasses_increases_in_value_by_3_when_less_than_5_days_to_go() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }
    @Test
    void backstagePasses_increases_in_value_by_1_when_more_than_10_days_to_go() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void Aged_Brie_increases_in_value_by_1_when_sellIn_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

}
