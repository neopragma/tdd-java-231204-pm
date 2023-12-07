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
    void conjuredManaCake_quality_does_not_go_negative() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
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
    }    @Test
    void backstagePasses_has_no_value_after_the_concert_is_over() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void backstagePasses_does_not_increase_in_value_when_value_is_already_50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void backstagePasses_caps_increase_at_50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void Aged_Brie_increases_in_value_by_1_when_sellIn_greater_than_zero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void Aged_Brie_increases_in_value_by_2_when_sellIn_less_than_1() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void Aged_Brie_does_not_increase_in_value_when_value_is_already_50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void Sulfuras_always_has_quality_80() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 2, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void normal_items_degrade_by_1_until_sellIn_date() {
        Item[] items = new Item[] {
                new Item("random normal item", 2, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].quality);
    }

}
