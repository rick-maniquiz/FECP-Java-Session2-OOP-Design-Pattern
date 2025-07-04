package org.example.Transactions;

import org.example.DigitalAsset;
import org.example.Transaction;

public class SellAsset extends Transaction {
    public SellAsset(){
        this.transactionType = "sell";
    }
    @Override
    public void executeTransaction(){
        DigitalAsset assetToSell = null;
        DigitalAsset cashAsset = null;
        for (DigitalAsset asset : this.walletAssets) {
            if (this.digitalAsset1 != null && asset.assetName.equals(this.digitalAsset1.assetName)) {
                assetToSell = asset;
            }
            if (asset.assetName.equals("Digital Cash")) {
                cashAsset = asset;
            }
        }
        if (assetToSell == null || cashAsset == null || this.amount <= 0 || assetToSell.getAmountOwned() < this.amount || assetToSell.price < 0) {
            System.out.println("Transaction Failed: Invalid asset, amount, balance, or price.");
            return;
        }
        double cashReceived = this.amount * assetToSell.price;
        assetToSell.setAmountOwned(assetToSell.getAmountOwned() - this.amount);
        cashAsset.setAmountOwned(cashAsset.getAmountOwned() + cashReceived);
    }
}
