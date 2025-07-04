//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class Cardano extends DigitalAsset {
//
//    public Cardano(){
//        this.assetName = "Cardano";
//        this.assetTicker = "$ADA";
//        this.price = 100;
//    }
//
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class Cardano extends DigitalAsset {

    public Cardano() {
        super("Cardano", "ADA", 100); // Example price
    }
}

