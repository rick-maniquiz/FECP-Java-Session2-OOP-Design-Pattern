//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class InvalidAsset extends DigitalAsset {
//
//    public InvalidAsset(){
//        this.assetName = "Invalid Asset";
//        this.assetTicker = "INVALID";
//        this.price = -1;
//    }
//
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class InvalidAsset extends DigitalAsset {

    public InvalidAsset() {
        super("Invalid Asset", "INVALID", -1);
    }
}

