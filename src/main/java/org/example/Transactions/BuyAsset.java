package org.example.Transactions;

import org.example.DigitalAsset;
import org.example.Transaction;

public class BuyAsset extends Transaction {
    public BuyAsset(){
        this.transactionType = "buy";
    }
    @Override
    public void executeTransaction(){

        DigitalAsset cashAsset = null;
        for (DigitalAsset asset : this.walletAssets) {
            if (asset.assetName.equals("Digital Cash")) {
                cashAsset = asset;
                break;
            }
        }
        if (cashAsset == null || cashAsset.getAmountOwned() < this.amount) {
            System.out.println("Transaction Failed: Insufficient funds.");
            return;
        }
        for (DigitalAsset asset: this.walletAssets){
            if (asset.assetName.equals(this.digitalAsset1.assetName)){
                double newAmount = asset.getAmountOwned() + (this.amount / asset.price);
                asset.setAmountOwned(newAmount);
            }
            if (asset.assetName.equals("Digital Cash")){
                double newAmount = asset.getAmountOwned() - this.amount;
                asset.setAmountOwned(newAmount);
            }
        }
    }
}
