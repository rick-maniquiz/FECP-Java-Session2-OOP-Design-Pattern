package org.example;

import org.example.DigitalAssets.DigitalCash;
import org.example.DigitalAssets.InvalidAsset;

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


    // You can use the two following methods to get balance and price of the assets inside
    // to check whether or not you have enough balance
    double getBalanceOfDigitalAsset(String assetName){
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals(assetName)){
                return asset.getAmountOwned();
            }
        }
        System.out.println("No " + assetName + " is available in the market");
        return new InvalidAsset().getAmountOwned();
    }
    double getPriceOfDigitalAsset(String assetName){
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals(assetName)){
                return asset.price;
            }
        }
        System.out.println("No " + assetName + " is available in the market");
        return new InvalidAsset().price;
    }

    void setTransactionType(Transaction transactionType){
        this.transactionType = transactionType;
    }

    void makeTransaction(DigitalAsset digitalAsset, double amount){
        this.transactionType.makeTransaction(this.digitalAssets, digitalAsset, amount);
        System.out.println("You are about to " + this.transactionType.transactionType + " " + amount + " worth of " + digitalAsset.assetName + ".");
        System.out.println("Would you like to proceed?");
    }

    void executeTransaction(){
        this.transactionType.executeTransaction();
    }




}
