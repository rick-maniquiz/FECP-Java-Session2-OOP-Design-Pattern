# Cryptocurrency Exchange System

---

## Group Information

- **Group Name:** Group 10
- **Members:**
  - Frondonzo, Ivan
  - Maniquiz, Rafael Nico
  - Sian, Adrian Garett

---

## Project Description

This project is a command-line based cryptocurrency exchange simulation built in Java. It allows users to manage a virtual wallet, buy and sell various digital assets like Bitcoin and Ethereum, and manage their digital cash balance. The system demonstrates key object-oriented programming principles, including abstraction, inheritance, and design patterns like the Factory and Strategy patterns to handle different transaction types and asset creation.

---

## Project Structure

The project is organized into several packages to separate concerns, making the codebase clean and maintainable.

src
└── org
└── example
├── DigitalAssets
│ ├── Bitcoin.java
│ ├── Cardano.java
│ ├── DigitalCash.java
│ ├── Dogecoin.java
│ ├── Ethereum.java
│ ├── InvalidAsset.java
│ └── ShibaInu.java
│
├── Transactions
│ ├── BuyAsset.java
│ └── SellAsset.java
│
├── CryptoExchange.java // Main method to run the application
├── CryptoMarket.java // Factory/Registry for available assets
├── DigitalAsset.java // Abstract base class for all assets
├── Transaction.java // Abstract base class for transactions
└── Wallet.java // Manages user's assets and balance

## Output Screenshot

Below is a sample screenshot demonstrating the application's command-line interface during a "buy" transaction.
![Buy Asset](https://github.com/rick-maniquiz/FECP-Java-Session2-OOP-Design-Pattern/blob/32896118491716407187e248f752fa55abb9cee5/img/BuyAsset.png)
![Sell Asset](https://github.com/rick-maniquiz/FECP-Java-Session2-OOP-Design-Pattern/blob/32896118491716407187e248f752fa55abb9cee5/img/SellAsset.png)
![View Wallet](https://github.com/rick-maniquiz/FECP-Java-Session2-OOP-Design-Pattern/blob/32896118491716407187e248f752fa55abb9cee5/img/ViewWallet.png)
![Deposit Digital Cash](https://github.com/rick-maniquiz/FECP-Java-Session2-OOP-Design-Pattern/blob/32896118491716407187e248f752fa55abb9cee5/img/DepositDigitalCash.png)
