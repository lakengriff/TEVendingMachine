package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Balance {
    BigDecimal balance = new BigDecimal("0.00");
    Scanner input = new Scanner(System.in);
    Logger logger = new Logger();

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney() { //TODO Make the verbage a little more clear
        //Purpose: User gives an amount to add to balance.

        System.out.println("Hungry? Please deposit money in a whole-dollar amount. I cannot accept change. (ex. 1.00)");
        String moneyAdded = input.nextLine();
        if (!moneyAdded.contains(".00")) {
            System.out.println("Please enter in a whole dollar amount. This machine don't do coins.");
            System.out.println("*********");

        } else
            System.out.println("You have added $ " + moneyAdded);
//        double monAddDouble = Double.parseDouble(moneyAdded);
        BigDecimal monAddBd = new BigDecimal(moneyAdded);
//        balance = balance.add(monAddBd);
        setBalance(balance.add(monAddBd));
        String feedMoneyString = "FEED MONEY: " + moneyAdded + " " + balance;
        logger.log(feedMoneyString);
    }

    public void dispenseItem(Map<String, Product> inventoryMap, Balance customerBalance, String purchaseChoice, Inventory inventory) {

        inventory.displayItems(inventoryMap);
        System.out.println("Please make your selection (ex: B2) :");
        purchaseChoice = input.nextLine();
        if (!inventoryMap.containsKey(purchaseChoice)) {
            System.out.println("Please enter a valid selection");
        } else {
            Product product = inventoryMap.get(purchaseChoice);
            if (product.getQuantity() == 0) {
                System.out.println("Sorry, that item is sold out.");
            }
            if ((customerBalance.getBalance().compareTo(product.getPrice()) >= 0) && (product.getQuantity() > 0)) {
                product.setQuantity(product.getQuantity() - 1);
                customerBalance.setBalance(customerBalance.getBalance().subtract(product.getPrice()));
                System.out.println("You received " + product.getProductName() + " at the low, low price of $" + product.getPrice() + ". You have $" + customerBalance.getBalance() + " remaining.");
                System.out.println(product.getSound());
                String dispenseLog = product.getProductName() + " " + product.getProductID() + " " + product.getPrice() + " " + customerBalance.getBalance();
                logger.log(dispenseLog);
            } else if (customerBalance.getBalance().compareTo(product.getPrice()) == -1) {
                System.out.println("Insufficient funds. Please add more money to complete transaction.");
            }
        }

    }


}
