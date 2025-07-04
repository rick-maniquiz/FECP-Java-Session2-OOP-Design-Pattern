//public class CryptoExchange {
//    public static void main(String[] args){
//        Wallet myWallet = new Wallet();
//        myWallet.setTransactionType(new BuyAsset());
//        myWallet.transactionType.makeTransaction(new Bitcoin(), 10000);
//        myWallet.transactionType.executeTransaction();
//
//    }
//}

package org.example;

import org.example.Transactions.BuyAsset;
import org.example.Transactions.SellAsset;
import org.example.DigitalAssets.InvalidAsset;

import java.util.*;

public class CryptoExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet(100000);
        CryptoMarket market = new CryptoMarket();

        boolean running = true;
        while (running) {
            System.out.println("\n=== CRYPTOCURRENCY EXCHANGE SYSTEM ===");
            System.out.println("1. View Wallet");
            System.out.println("2. Buy Asset");
            System.out.println("3. Sell Asset");
            System.out.println("4. Deposit Digital Cash");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    wallet.displayAllDigitalAssets();
                    break;

                case 2:
                    System.out.print("Enter asset name to buy: ");
                    String buyAssetName = scanner.nextLine();
                    DigitalAsset buyAsset = market.getDigitalAsset(buyAssetName);
                    if (buyAsset instanceof InvalidAsset) {
                        System.out.println("Invalid asset selected.");
                        break;
                    }

                    System.out.print("Enter amount in ₱ to spend: ");
                    double buyAmount = scanner.nextDouble();
                    scanner.nextLine();

                    double digitalCashBalance = wallet.getBalanceOfDigitalAsset("Digital Cash");
                    if (buyAmount <= 0) {
                        System.out.println("Invalid amount.");
                        break;
                    } else if (buyAmount > digitalCashBalance) {
                        System.out.println("Invalid amount. You only have ₱" + digitalCashBalance);
                        break;
                    }

                    wallet.setTransactionType(new BuyAsset());
                    wallet.makeTransaction(buyAsset, buyAmount);
                    wallet.executeTransaction();

                    System.out.println("Purchase complete.");
                    System.out.println("New balance of " + buyAsset.assetName + ": " + wallet.getBalanceOfDigitalAsset(buyAsset.assetName));
                    System.out.println("Remaining Digital Cash: ₱" + wallet.getBalanceOfDigitalAsset("Digital Cash"));
                    break;

                case 3:
                    System.out.print("Enter asset name to sell: ");
                    String sellAssetName = scanner.nextLine();
                    DigitalAsset sellAsset = market.getDigitalAsset(sellAssetName);
                    if (sellAsset.assetName.equals("Invalid Asset")) {
                        System.out.println("You don't own this asset or it's not sellable.");
                        break;
                    }

                    System.out.print("Enter amount to sell (in units): ");
                    double sellAmount = scanner.nextDouble();
                    scanner.nextLine();

                    double ownedAmount = wallet.getBalanceOfDigitalAsset(sellAsset.assetName);
                    if (sellAmount <= 0) {
                        System.out.println("Invalid amount");
                        break;
                    } else if (sellAmount > ownedAmount) {
                        System.out.println("Invalid amount. You only own " + ownedAmount + " " + sellAsset.assetName);
                        break;
                    }

                    wallet.setTransactionType(new SellAsset());
                    wallet.makeTransaction(sellAsset, sellAmount);
                    wallet.executeTransaction();

                    System.out.println("Sale complete.");
                    System.out.println("Updated Digital Cash balance: PHP" + wallet.getBalanceOfDigitalAsset("Digital Cash"));
                    System.out.println("Remaining " + sellAsset.assetName + ": " + wallet.getBalanceOfDigitalAsset(sellAsset.assetName));
                    break;


                case 4:
                    System.out.print("Enter amount to deposit in ₱: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid deposit amount.");
                        break;
                    }

                    wallet.addDigitalCash(depositAmount);
                    System.out.println("PHP" + depositAmount + " added to your Digital Cash.");
                    System.out.println("Current Digital Cash balance: ₱" + wallet.getBalanceOfDigitalAsset("Digital Cash"));
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system.");
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
