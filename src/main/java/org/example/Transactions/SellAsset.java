package org.example.Transactions;

import org.example.DigitalAsset;
import org.example.Transaction;

public class SellAsset extends Transaction {
    public SellAsset(){
        this.transactionType = "sell";
    }
    @Override
    public void executeTransaction(){
        for (DigitalAsset asset: this.walletAssets){
            if (asset.assetName.equals(this.digitalAsset1.assetName)){
                double newAmount = asset.getAmountOwned() - (this.amount * asset.price);
                asset.setAmountOwned(newAmount);
            }
        }
    }
}
