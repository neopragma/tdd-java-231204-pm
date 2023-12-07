package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            int degradationAmount = 1;
            if (item.name.equals("Aged Brie")) {
                degradationAmount = -1;
            } else if (item.name.equals("Conjured Mana Cake")) {
                degradationAmount = 2;
            }
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 1) {
                    degradationAmount = item.quality;
                } else if (item.sellIn <= 5) {
                    degradationAmount = -3;
                } else if (item.sellIn <= 10) {
                    degradationAmount = -2;
                } else {
                    degradationAmount = -1;
                }
            } else if (item.sellIn < 1) {
                degradationAmount *= 2;
            }
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                degradationAmount = 0;
            }
            if (item.quality != 0
                    || item.name.equals("Aged Brie")
                    || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = item.quality - degradationAmount;
                if (item.quality > 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = 50;
                }
            }
            item.sellIn -= 1;
        }
    }
}