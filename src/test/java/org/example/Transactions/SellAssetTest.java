package org.example.Transactions;

import org.junit.jupiter.api.BeforeEach;
import org.example.CryptoMarket;
import org.example.DigitalAsset;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SellAssetTest {
    private SellAsset sellAsset;
    private ArrayList<DigitalAsset> walletAssets;
    private DigitalAsset cardano;
    private DigitalAsset bitcoin;
    private DigitalAsset digitalCash;
    private CryptoMarket cryptoMarket;

    @BeforeEach
    void setup(){
        cryptoMarket = new CryptoMarket();
        sellAsset = new SellAsset();
        walletAssets = new ArrayList<>();

        // Get all assets from the market
        bitcoin = cryptoMarket.getDigitalAsset("Bitcoin");
        digitalCash = cryptoMarket.getDigitalAsset("Digital Cash");
        cardano = cryptoMarket.getDigitalAsset("Cardano");

        // Set the starting amounts in the wallet
        bitcoin.setAmountOwned(2.0);
        digitalCash.setAmountOwned(5000000.0);
        cardano.setAmountOwned(5.0);

        walletAssets.add(bitcoin);
        walletAssets.add(digitalCash);
        walletAssets.add(cardano);
    }
    @Test
    void shouldSellAssetAndUpdateWallet() {
        double amountToSell = 2.0; // Sell 2 Cardano
        sellAsset.makeTransaction(walletAssets, cardano, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(3.0, cardano.getAmountOwned(), "The amount of Cardano should decrease correctly.");
        assertEquals(5000000.0 + (amountToSell * cardano.price), digitalCash.getAmountOwned(), "The amount of Digital Cash should increase correctly.");
    }

    @Test
    void shouldNotSellAssetIfInsufficientAmount() {
        double amountToSell = 10.0;
        sellAsset.makeTransaction(walletAssets, cardano, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(5.0, cardano.getAmountOwned(), "Cardano amount should remain unchanged.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Digital Cash amount should remain unchanged.");
    }

    @Test
    void shouldNotSellAssetIfNotInWallet() {
        walletAssets.remove(cardano);
        double amountToSell = 2.0;
        sellAsset.makeTransaction(walletAssets, cardano, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Digital Cash should not change.");
    }

    @Test
    void shouldNotSellAssetIfAmountIsZero() {
        double amountToSell = 0.0;
        sellAsset.makeTransaction(walletAssets, bitcoin, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin balance should not change.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Cash balance should not change.");
    }

    @Test
    void shouldNotSellAssetIfAmountIsNegative() {
        double amountToSell = -1.0;
        sellAsset.makeTransaction(walletAssets, bitcoin, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin balance should not change.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Cash balance should not change.");
    }

    @Test
    void shouldHaveZeroBalanceAfterSellingAll() {
        double amountToSell = 2.0;
        sellAsset.makeTransaction(walletAssets, bitcoin, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(0.0, bitcoin.getAmountOwned(), "Bitcoin amount should be exactly zero.");
    }

    @Test
    void shouldNotSellAssetIfPriceIsNegative() {
        bitcoin.setPrice(-1000.0);
        double amountToSell = 1.0;
        sellAsset.makeTransaction(walletAssets, bitcoin, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin balance should not change.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Cash balance should not change.");
    }

}