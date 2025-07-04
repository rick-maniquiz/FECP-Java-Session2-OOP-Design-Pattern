//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class Dogecoin extends DigitalAsset {
//
//    public Dogecoin(){
//        this.assetName = "Dogecoin";
//        this.assetTicker = "$DOGE";
//        this.price = 3;
//    }
//
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class Dogecoin extends DigitalAsset {

    public Dogecoin() {
        super("Dogecoin", "$DOGE", 3);
    }
}

