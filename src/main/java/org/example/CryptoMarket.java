package org.example;


import org.example.DigitalAssets.*;

import java.util.ArrayList;

// Factory pattern will be demonstrated using this class
public class CryptoMarket {
    private static CryptoMarket instance = new CryptoMarket();
    public ArrayList<DigitalAsset> availableDigitalAssets = new ArrayList<>();
    CryptoMarket(){
        availableDigitalAssets.add(new Bitcoin());
        availableDigitalAssets.add(new Cardano());
        availableDigitalAssets.add(new DigitalCash());
        availableDigitalAssets.add(new Dogecoin());
        availableDigitalAssets.add(new Ethereum());
        availableDigitalAssets.add(new ShibaInu());
    }
    DigitalAsset getDigitalAsset(String assetName){
        for (DigitalAsset asset: this.availableDigitalAssets){
            if (asset.assetName.equals(assetName)){
                return asset;
            }
        }
        System.out.println("No " + assetName + " is available in the market");
        return new InvalidAsset();
    }

    CryptoMarket getInstance(){
        return instance;
    }
}
