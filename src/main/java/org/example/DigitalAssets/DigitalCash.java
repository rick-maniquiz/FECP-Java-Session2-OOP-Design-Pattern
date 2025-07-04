//package org.example.DigitalAssets;
//
//import org.example.DigitalAsset;
//
//public class DigitalCash extends DigitalAsset {
//
//    public DigitalCash(){
//        this.assetName = "Digital Cash";
//        this.assetTicker = "N/A";
//        this.price = 1;
//    }
//}

package org.example.DigitalAssets;

import org.example.DigitalAsset;

public class DigitalCash extends DigitalAsset {

    public DigitalCash() {
        super("Digital Cash", "N/A", 1);
    }
}
