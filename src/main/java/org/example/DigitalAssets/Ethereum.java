//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class Ethereum extends DigitalAsset {
//
//    public Ethereum(){
//        this.assetName = "Ethereum";
//        this.assetTicker = "$ETH";
//        this.price = 100000;
//    }
//
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class Ethereum extends DigitalAsset {

    public Ethereum() {
        super("Ethereum", "ETH", 100000);
    }
}
