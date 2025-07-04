package org.example;

public abstract class DigitalAsset {
    public String assetName, assetTicker;
    public double price;
    protected double amountOwned = 0;



    public void displayDetails(){

    }

    public double getAmountOwned(){
        return this.amountOwned;
    }

    public void setAmountOwned(double newAmountOwned){
        this.amountOwned = newAmountOwned;
    }

}
