package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    protected static final int MAX_ITEM_QUALITY = 50;
    protected static final int MIN_ITEM_QUALITY = 0;
    protected static final int ZERO_DAYS = 0;

    protected String name;

    protected int sellIn;

    protected int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrie(sellIn, quality);
            case BACKSTAGE_PASS:
                return new BackstagePass(sellIn, quality);
            case SULFURAS:
                return new Sulfuras(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void doUpdateQuality() {

        if (hasGoodQuality()) {
            decreaseQuality();
        }

        decreaseSellIn();

        if (hasExpired() && hasGoodQuality()) {
            decreaseQuality();
        }

    }

    protected void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    private void decreaseQuality() {
        quality = quality - 1;
    }

    protected void increaseQuality() {
        quality = quality + 1;
    }

    protected boolean hasNotReachedMaxQuality() {
        return quality < MAX_ITEM_QUALITY;
    }

    protected boolean hasExpired() {
        return sellIn < ZERO_DAYS;
    }

    protected boolean hasGoodQuality() {
        return quality > MIN_ITEM_QUALITY;
    }
}
