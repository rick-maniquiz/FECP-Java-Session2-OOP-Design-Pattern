package org.example.Transactions;

import org.junit.jupiter.api.BeforeEach;
import org.example.CryptoMarket;
import org.example.DigitalAsset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SellAssetTest {
    private SellAsset sellAsset;
    private ArrayList<DigitalAsset> walletAssets;
    private DigitalAsset cardano;
    private DigitalAsset digitalCash;
   private CryptoMarket cryptoMarket;

    @BeforeEach
    void setup(){
        cryptoMarket = new CryptoMarket();
        sellAsset = new SellAsset();
        walletAssets = new ArrayList<>();

        cardano = cryptoMarket.getDigitalAsset("Cardano");
        digitalCash = cryptoMarket.getDigitalAsset("Digital Cash");

        cardano.setAmountOwned(5.0);
        digitalCash.setAmountOwned(1000000.0);

        walletAssets.add(cardano);
        walletAssets.add(digitalCash);
    }
    @Test
    void shouldSellAssetAndUpdateWallet() {
        double amountToSell = 2.0; // Sell 2 Cardano
        sellAsset.makeTransaction(walletAssets, cardano, amountToSell);
        sellAsset.executeTransaction();
        assertEquals(3.0, cardano.getAmountOwned(), "The amount of Cardano should decrease correctly.");
        assertEquals(1000000.0 + (amountToSell * cardano.price), digitalCash.getAmountOwned(), "The amount of Digital Cash should increase correctly.");
    }

}