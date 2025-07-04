package org.example;

import org.example.DigitalAssets.Bitcoin;
import org.example.DigitalAssets.DigitalCash;
import org.example.Transactions.BuyAsset;
import org.example.Transactions.SellAsset;

public class CryptoExchangeDemo {
    public static void main(String[] args){
        Wallet myWallet = new Wallet(1000000);
        CryptoMarket market = new CryptoMarket();

        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));

        DigitalAsset assetToBuy = market.getDigitalAsset("Bitcoin");
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000); // amount to buy in Digital Cash
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(new Bitcoin(), 0.1); // amount to sell in Bitcoin(or any asset)
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

        System.out.println("");
        myWallet.displayAllDigitalAssets();

        assetToBuy = market.getDigitalAsset("Ethereum");
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Ethereum Balance: " + myWallet.getBalanceOfDigitalAsset("Ethereum"));

        assetToBuy = market.getDigitalAsset("Dogecoin");
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Dogecoin Balance: " + myWallet.getBalanceOfDigitalAsset("Dogecoin"));

        assetToBuy = market.getDigitalAsset("Shiba Inu");
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Shiba Inu Balance: " + myWallet.getBalanceOfDigitalAsset("Shiba Inu"));

        assetToBuy = market.getDigitalAsset("Cardano");
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Cardano Balance: " + myWallet.getBalanceOfDigitalAsset("Cardano"));

        myWallet.displayAllDigitalAssets();

    }
}
