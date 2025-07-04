package org.example;

import java.util.ArrayList;

public abstract class Transaction {
    public String transactionType;
    public ArrayList<DigitalAsset> walletAssets;
    public DigitalAsset digitalAsset1;
    public double amount;
//    private int transactionStatusCode;

//    int checkTransactionValidity(DigitalAsset digitalAsset1, double amount){
//        // Check if the transaction will be valid (i.e. if the amount is right, balance is sufficient, etc.)
//        // Return status codes to see what is wrong,
//        // for example return 101 if the valid is negative, 102 if balance is insufficient.
//        return 1; // if all is good to go, return 1;
//    }

    public void makeTransaction(ArrayList<DigitalAsset> walletAssets, DigitalAsset digitalAsset1, double amount){
        this.walletAssets = walletAssets;
        this.digitalAsset1 = digitalAsset1;
        this.amount = amount;
//        this.transactionStatusCode = checkTransactionValidity(digitalAsset1, amount);
    }

//    void checkTransactionDetails(){
//        // Just print the transaction details
//    }

    public void executeTransaction(){
//        this.transactionStatusCode = 0; // Set it to 0 if it has been executed
        //return 0;
//    }

//    int getTransactionStatusCode(){
//        return this.transactionStatusCode;
   }
}
