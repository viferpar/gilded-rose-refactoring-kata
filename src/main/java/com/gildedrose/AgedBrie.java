package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
        if (hasNotReachedMaxQuality()) {
            increaseQuality();
        }

        decreaseSellIn();

        if (hasExpired() && hasNotReachedMaxQuality()) {
            increaseQuality();
        }
    }
}
