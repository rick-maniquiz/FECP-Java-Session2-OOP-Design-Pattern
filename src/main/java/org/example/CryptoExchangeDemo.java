package org.example;

import org.example.DigitalAssets.Bitcoin;
import org.example.Transactions.BuyAsset;
import org.example.Transactions.SellAsset;

public class CryptoExchangeDemo {
    public static void main(String[] args){
        Wallet myWallet = new Wallet(1000000);

        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));

        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(new Bitcoin(), 100000);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

        myWallet.setTransactionType(new SellAsset());
        myWallet.makeTransaction(new Bitcoin(), 0.1);
        myWallet.executeTransaction();
        System.out.println("Digital Cash Balance: " + myWallet.getBalanceOfDigitalAsset("Digital Cash"));
        System.out.println("Bitcoin Balance: " + myWallet.getBalanceOfDigitalAsset("Bitcoin"));

    }
}
