package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DigitalAssetTest {
    private DigitalAsset digitalAsset;

    @BeforeEach
    void setup() {
        digitalAsset = new DigitalAsset("Test Coin", "$TEST", 100.0) {};
    }
    @Test
    void shouldInitializeCorrectlyViaConstructor() {
        assertEquals("Test Coin", digitalAsset.getAssetName(), "Asset name should be set by the constructor.");
        assertEquals("$TEST", digitalAsset.assetTicker, "Asset ticker should be set by the constructor.");
        assertEquals(100.0, digitalAsset.getPrice(), "Price should be set by the constructor.");
        assertEquals(0.0, digitalAsset.getAmountOwned(), "Initial amount owned should default to zero.");
    }
    @Test
    void shouldSetAndGetAmountOwned() {
        digitalAsset.setAmountOwned(50.5);
        assertEquals(50.5, digitalAsset.getAmountOwned(), "getAmountOwned should return the updated value.");
    }
    @Test
    void shouldSetAndGetPrice() {
        digitalAsset.setPrice(123.45);
        assertEquals(123.45, digitalAsset.getPrice(), "getPrice should return the updated value.");
    }
    @Test
    void shouldAllowSettingAmountOwnedToZero() {
        digitalAsset.setAmountOwned(50.0); // Start with a non-zero value
        digitalAsset.setAmountOwned(0.0);
        assertEquals(0.0, digitalAsset.getAmountOwned(), "Should be able to set amount owned to zero.");
    }


}