package org.example.Transactions;

import org.example.CryptoMarket;
import org.example.DigitalAsset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BuyAssetTest {
    private BuyAsset buyAsset;
    private ArrayList<DigitalAsset> walletAssets;
    private DigitalAsset bitcoin;
    private DigitalAsset digitalCash;
    private CryptoMarket cryptoMarket;

    @BeforeEach
    void setup(){
        cryptoMarket = new CryptoMarket();
        buyAsset = new BuyAsset();
        walletAssets = new ArrayList<>();

        bitcoin = cryptoMarket.getDigitalAsset("Bitcoin");
        digitalCash = cryptoMarket.getDigitalAsset("Digital Cash");

        bitcoin.setAmountOwned(2.0);
        digitalCash.setAmountOwned(5000000.0);

        walletAssets.add(bitcoin);
        walletAssets.add(digitalCash);
    }

    @Test
    void shouldBuyAssetAndUpdateWallet() {
        double amountToSpend = 3000000.0;
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(5.0, bitcoin.getAmountOwned(), "The amount of Bitcoin should increase correctly.");
        assertEquals(2000000.0, digitalCash.getAmountOwned(), "The amount of Digital Cash should decrease correctly.");
    }

    @Test
    void shouldNotBuyAssetIfInsufficientFunds() {
        double amountToSpend = 6000000.0; // More than available Digital Cash
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "The amount of Bitcoin should remain unchanged.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "The amount of Digital Cash should remain unchanged.");
    }

    @Test
    void shouldSucceedWhenBuyingAssetNotInWallet() {
        walletAssets.remove(bitcoin);
        assertEquals(1, walletAssets.size());
        double amountToSpend = 1000000.0; // Buy one Bitcoin
        DigitalAsset assetToBuy = cryptoMarket.getDigitalAsset("Bitcoin");
        buyAsset.makeTransaction(walletAssets, assetToBuy, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2, walletAssets.size(), "Wallet should now contain two assets.");
        assertEquals(4000000.0, digitalCash.getAmountOwned(), "Cash should be deducted correctly.");
        assertEquals(1.0, assetToBuy.getAmountOwned(), "The new asset should be in the wallet with the correct amount.");
    }

    @Test
    void shouldNotBuyAssetIfAmountIsZero(){
        double amountToSpend = 0.0; // Zero amount
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "The amount of Bitcoin should remain unchanged.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "The amount of Digital Cash should remain unchanged.");
    }

    @Test
    void shouldNotBuyAssetIfAmountIsNegative() {
        double amountToSpend = -1000000.0; // Negative amount
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "The amount of Bitcoin should remain unchanged.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "The amount of Digital Cash should remain unchanged.");
    }

    @Test
    void shouldNotBuyAssetIfAssetPriceIsZero() {
        bitcoin.setPrice(0.0);
        double amountToSpend = 1000.0;
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin amount should not change.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Cash amount should not change.");
    }

    @Test
    void shouldNotBuyAssetIfDigitalCashNotInWallet() {
        walletAssets.remove(digitalCash);
        assertEquals(1, walletAssets.size());
        double amountToSpend = 1000.0;
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin amount should not change.");
        assertEquals(1, walletAssets.size(), "No new asset should have been added to the wallet.");
    }
    @Test
    void shouldNotBuyAssetIfDigitalCashAmountIsZero() {
        digitalCash.setAmountOwned(0.0);
        double amountToSpend = 1000.0; // Attempt to buy with zero Digital Cash
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin amount should not change.");
        assertEquals(0.0, digitalCash.getAmountOwned(), "Digital Cash amount should remain zero.");
    }
    @Test
    void shouldNotBuyAssetIfDigitalCashAmountIsNegative() {
        digitalCash.setAmountOwned(-1000.0); // Negative amount of Digital Cash
        double amountToSpend = 1000.0; // Attempt to buy with negative Digital Cash
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin amount should not change.");
        assertEquals(-1000.0, digitalCash.getAmountOwned(), "Digital Cash amount should remain negative.");
    }
    @Test
    void shouldNotBuyAssetIfAssetPriceIsNegative() {
        bitcoin.setPrice(-1000.0); // Negative price
        double amountToSpend = 1000.0; // Attempt to buy with negative asset price
        buyAsset.makeTransaction(walletAssets, bitcoin, amountToSpend);
        buyAsset.executeTransaction();
        assertEquals(2.0, bitcoin.getAmountOwned(), "Bitcoin amount should not change.");
        assertEquals(5000000.0, digitalCash.getAmountOwned(), "Digital Cash amount should remain unchanged.");
    }
}