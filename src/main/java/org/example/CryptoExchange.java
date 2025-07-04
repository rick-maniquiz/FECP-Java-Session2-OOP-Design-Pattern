package org.example;

import org.example.DigitalAssets.Bitcoin;
import org.example.Transactions.BuyAsset;

public class CryptoExchange {
    public static void main(String[] args){
        Wallet myWallet = new Wallet();
        myWallet.setTransactionType(new BuyAsset());
        myWallet.makeTransaction(new Bitcoin(), 10000);
        myWallet.executeTransaction();

    }
}
