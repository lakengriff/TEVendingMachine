package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Balance {
    BigDecimal balance = new BigDecimal("0.00");
    Scanner input = new Scanner(System.in);
    Inventory inventory = new Inventory();

    public BigDecimal feedMoney() {
        System.out.println("Hungry? Please deposit money (in $1.00 increments) by typing 1.00 and pressing Enter");
        System.out.println("Or press Q to return to menu");
        String moneyAdded = input.nextLine();
        if (moneyAdded.equalsIgnoreCase("Q")) {
        return balance; }
        else if (!moneyAdded.contains(".00")) {
            System.out.println("Please enter in a whole dollar amount. This machine don't do coins.");
            System.out.println("*********");
            return balance;


        } else
            System.out.println("You have added $ " + moneyAdded);
        double monAddDouble = Double.parseDouble(moneyAdded);
        BigDecimal monAddBd = new BigDecimal(monAddDouble);
        balance = balance.add(monAddBd);
        return balance;
    }

    public BigDecimal getProductPrice(String locationID) {
        return inventory.productHashMap.get(locationID).getPrice();
    }

    public BigDecimal balanceAfterPurchase(String locationID) {
        balance = balance.subtract(getProductPrice(locationID));
        return balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
