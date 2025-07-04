package org.example;

import org.example.DigitalAssets.DigitalCash;
import org.example.DigitalAssets.InvalidAsset;
import org.example.Transaction;

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

//    void makeTransaction(DigitalAsset digitalAsset, double amount){
//        // NOTE: To make a better test cases for checking whether the transaction went through or not,
//        // kindly consider adding the error/validity checks here
//        this.transactionType.makeTransaction(this.digitalAssets, digitalAsset, amount);
//        System.out.println("You are about to " + this.transactionType.transactionType + " " + amount + " worth of " + digitalAsset.assetName + ".");
//        System.out.println("Would you like to proceed?");
//    }
//
//    void executeTransaction(){
//        // adding the error/validity checks might also work here
//        for (DigitalAsset asset: this.digitalAssets){
//            if (asset.assetName.equals(this.transactionType.digitalAsset1.assetName)){
//                this.transactionType.executeTransaction();
//                return;
//            }
//        }
//        this.digitalAssets.add(this.transactionType.digitalAsset1);
//        this.transactionType.executeTransaction();
//
//    }
void makeTransaction(DigitalAsset digitalAsset, double amount) {
    if (digitalAsset == null || digitalAsset instanceof InvalidAsset) {
        System.out.println("Invalid asset.");
        return;
    }
    if (amount <= 0) {
        System.out.println("Amount must be greater than 0.");
        return;
    }

    // Check if it's a buy or sell
    if ("buy".equalsIgnoreCase(this.transactionType.transactionType)) {
        double digitalCash = getBalanceOfDigitalAsset("Digital Cash");
        if (amount > digitalCash) {
            System.out.println("Not enough Digital Cash. Available: ₱" + digitalCash);
            return;
        }
    } else if ("sell".equalsIgnoreCase(this.transactionType.transactionType)) {
        double ownedAmount = getBalanceOfDigitalAsset(digitalAsset.assetName);
        if (amount > ownedAmount) {
            System.out.println("Not enough " + digitalAsset.assetName + ". Owned: " + ownedAmount);
            return;
        }
    }

    this.transactionType.makeTransaction(this.digitalAssets, digitalAsset, amount);
    System.out.println("Prepared to " + this.transactionType.transactionType + " " + amount + " of " + digitalAsset.assetName + ".");
}
    void executeTransaction() {
        if (this.transactionType == null || this.transactionType.digitalAsset1 == null) {
            System.out.println("No transaction prepared.");
            return;
        }

        // Ensure the asset is in the wallet before executing
        boolean found = false;
        for (DigitalAsset asset : this.digitalAssets) {
            if (asset.assetName.equals(this.transactionType.digitalAsset1.assetName)) {
                found = true;
                break;
            }
        }

        if (!found) {
            this.digitalAssets.add(this.transactionType.digitalAsset1);
        }

        // Execute the transaction after confirming presence
        this.transactionType.executeTransaction();
        System.out.println("Transaction executed successfully.");
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
