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

    void addDigitalCash(double cashInAmount){
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals("Digital Cash")){
                double newAmount = asset.getAmountOwned() + cashInAmount;
                asset.setAmountOwned(newAmount);
            }
        }
    }


    // You can use the two following methods to get balance and price of the assets inside
    // to check whether or not you have enough balance
    double getBalanceOfDigitalAsset(String assetName){
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals(assetName)){
                return asset.getAmountOwned();
            }
        }
        System.out.println("No " + assetName + " is available in the wallet");
        return new InvalidAsset().getAmountOwned();
    }
    double getPriceOfDigitalAsset(String assetName){
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals(assetName)){
                return asset.price;
            }
        }
        System.out.println("No " + assetName + " is available in the wallet");
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
        for (DigitalAsset asset: this.digitalAssets){
            if (asset.assetName.equals(this.transactionType.digitalAsset1.assetName)){
                this.transactionType.executeTransaction();
                return;
            }
        }
        this.digitalAssets.add(this.transactionType.digitalAsset1);
        this.transactionType.executeTransaction();

    }

    void displayAllDigitalAssets(){
        System.out.println("=== Available Assets ===");
        for (DigitalAsset asset: this.digitalAssets){
            System.out.println("Asset Name: "+asset.assetName);
            System.out.println("Ticker: "+asset.assetTicker);
            System.out.println("Price: "+asset.price);
            System.out.println("Amount Owned: "+asset.getAmountOwned());
            System.out.println("-----------------------");
        }
    }

    double calculateTotalWalletValue(){
        double value = 0.0;
        for (DigitalAsset asset: this.digitalAssets){
            value += asset.price * asset.getAmountOwned();
        }
        return value;
    }




}
