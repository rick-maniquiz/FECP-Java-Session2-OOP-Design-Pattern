package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class Bitcoin extends DigitalAsset {
    public Bitcoin(){
        this.assetName = "Bitcoin";
        this.assetTicker = "$BTC";
        this.price = 1000000;
    }
}
