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
        if (cashAsset == null || this.amount <= 0 || cashAsset.getAmountOwned() < this.amount || this.digitalAsset1.price <= 0) {
            System.out.println("Transaction Failed: Invalid amount, insufficient funds, or invalid asset price.");
            return;
        }
        boolean assetFoundInWallet = false;

        for (DigitalAsset asset : this.walletAssets) {
            if (asset.assetName.equals(this.digitalAsset1.assetName)) {
                double newAmount = asset.getAmountOwned() + (this.amount / asset.price);
                asset.setAmountOwned(newAmount);
                assetFoundInWallet = true;
            }
        }
        cashAsset.setAmountOwned(cashAsset.getAmountOwned() - this.amount);

        if (!assetFoundInWallet) {
            double newAssetAmount = this.amount / this.digitalAsset1.price;
            this.digitalAsset1.setAmountOwned(newAssetAmount);
            this.walletAssets.add(this.digitalAsset1);
        }
    }
}
