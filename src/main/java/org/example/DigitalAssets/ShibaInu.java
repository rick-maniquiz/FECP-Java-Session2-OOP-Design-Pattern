//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class ShibaInu extends DigitalAsset {
//
//    public ShibaInu(){
//        this.assetName = "Shiba Inu";
//        this.assetTicker = "$SHIB";
//        this.price = 2;
//    }
//
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class ShibaInu extends DigitalAsset {

    public ShibaInu() {
        super("ShibaInu", "SHIB", 0.0001); // Example price
    }
}

