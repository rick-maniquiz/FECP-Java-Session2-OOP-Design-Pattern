package org.example;

import org.example.DigitalAssets.DigitalCash;

import java.util.ArrayList;

// Strategy Pattern will be demonstrated using Wallet.transactionType
public class Wallet {
    public Transaction transactionType;
    private ArrayList<DigitalAsset> digitalAssets = new ArrayList<>();

    Wallet(){

    }
    Wallet(double digitalCashBalance){
        DigitalCash digitalCash = new DigitalCash();
        digitalCash.setAmountOwned(digitalCashBalance);
        digitalAssets.add(digitalCash);
    }

    void setTransactionType(Transaction transactionType){
        this.transactionType = transactionType;
    }



}
