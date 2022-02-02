package com.gildedrose;

public class BackstagePass extends Item {

    protected static final int TEN_DAYS_BEFORE_CONCERT = 10;
    protected static final int FIVE_DAYS_BEFORE_CONCERT = 5;

    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
        if (hasNotReachedMaxQuality()) {
            increaseQuality();

            boolean hasTenOrLessDaysBeforeConcert = sellIn <= TEN_DAYS_BEFORE_CONCERT;
            if (hasTenOrLessDaysBeforeConcert && hasNotReachedMaxQuality()) {
                increaseQuality();
            }

            boolean hasFiveDaysOrLessBeforeConcert = sellIn <= FIVE_DAYS_BEFORE_CONCERT;
            if (hasFiveDaysOrLessBeforeConcert && hasNotReachedMaxQuality()) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (hasExpired()) {
            quality = MIN_ITEM_QUALITY;
        }
    }
}
