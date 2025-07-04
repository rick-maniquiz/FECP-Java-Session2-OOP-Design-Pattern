//package org.example;
//
//public abstract class DigitalAsset {
//    public String assetName, assetTicker;
//    public double price;
//    protected double amountOwned = 0;
//
//
//
//    public void displayDetails(){
//
//    }
//
//    public double getAmountOwned(){
//        return this.amountOwned;
//    }
//
//    public void setAmountOwned(double newAmountOwned){
//        this.amountOwned = newAmountOwned;
//    }
//
//}


package org.example;

public abstract class DigitalAsset {
    public String assetName;
    public String assetTicker;
    public double price;
    protected double amountOwned = 0;

    // Constructor (optional, for subclasses to use)
    public DigitalAsset(String assetName, String assetTicker, double price) {
        this.assetName = assetName;
        this.assetTicker = assetTicker;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Asset Name: " + assetName);
        System.out.println("Ticker: " + assetTicker);
        System.out.println("Current Price: ₱" + price);
        System.out.println("Amount Owned: " + amountOwned);
    }

    public double getAmountOwned() {
        return this.amountOwned;
    }

    public void setAmountOwned(double newAmountOwned) {
        this.amountOwned = newAmountOwned;
    }
}

