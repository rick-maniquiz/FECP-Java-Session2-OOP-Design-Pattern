package org.example;

import org.example.DigitalAssets.Bitcoin;
import org.example.DigitalAssets.DigitalCash;
import org.example.Transactions.BuyAsset;
import org.example.Transactions.SellAsset;

public class CryptoExchangeDemo {
    public static void main(String[] args){
        Wallet myWallet = new Wallet(1000000);
        CryptoMarket market = new CryptoMarket();

        // NOTE: The Transaction classes do not check whether the

        System.out.println("Initial Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));

        System.out.println("Testing to buy the assets");
        DigitalAsset assetToBuy = market.getDigitalAsset("Bitcoin"); // Demo for the CryptoMarket Class
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(assetToBuy, 100000); // amount to buy in Digital Cash
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

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

        System.out.println("");
        myWallet.displayAllDigitalAssets();
        System.out.println("");
        System.out.println("Wallet total worth in Digital Cash: "+ myWallet.calculateTotalWalletValue()); // Should be equal to initial balance

        System.out.println("Testing to sell the assets");
        DigitalAsset assetToSell = market.getDigitalAsset("Bitcoin"); // Demo for the CryptoMarket Class
        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(assetToSell, 0.1); // amount to sell in Bitcoin (or any DigitalAsset)
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

        assetToSell = market.getDigitalAsset("Ethereum");
        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(assetToSell, 1);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Ethereum Balance: " + myWallet.getBalanceOfDigitalAsset("Ethereum"));

        assetToSell = market.getDigitalAsset("Dogecoin");
        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(assetToSell, 33333);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Dogecoin Balance: " + myWallet.getBalanceOfDigitalAsset("Dogecoin"));

        assetToSell = market.getDigitalAsset("Shiba Inu");
        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(assetToSell, 50000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Shiba Inu Balance: " + myWallet.getBalanceOfDigitalAsset("Shiba Inu"));

        assetToSell = market.getDigitalAsset("Cardano");
        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(assetToSell, 1000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Cardano Balance: " + myWallet.getBalanceOfDigitalAsset("Cardano"));

        System.out.println("");
        myWallet.displayAllDigitalAssets();
        System.out.println("");
        System.out.println("Wallet total worth in Digital Cash: "+ myWallet.calculateTotalWalletValue()); // Should be equal to initial balance




    }
}
