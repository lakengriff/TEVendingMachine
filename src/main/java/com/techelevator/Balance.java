package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Balance {
    BigDecimal balance = new BigDecimal("0.00");
    Scanner input = new Scanner(System.in);
    Logger logger = new Logger();
    private final static int QUARTER = 25;
    private final static int DIME = 10;
    private final static int NICKEL = 5;
    BigDecimal oneHundred = new BigDecimal("100");

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney() {

        System.out.println("Hungry? Please deposit money in a whole-dollar amount. I cannot accept change. (ex. 1.00)");
        String moneyAdded = input.nextLine();
        if (!moneyAdded.contains(".00")) {
            System.out.println("Please enter in a whole dollar amount, this machine does not accept coins.");
            System.out.println("*********");
        } else
            System.out.println("You have added $ " + moneyAdded);
        if (moneyAdded.contains(".00")) {
            try {
                BigDecimal monAddBd = new BigDecimal(moneyAdded);
                setBalance(balance.add(monAddBd));
                String feedMoneyString = "FEED MONEY: $" + moneyAdded + " $" + balance;
                logger.log(feedMoneyString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole-dollar amount.");
            }
        } else
            System.out.println("We'd really like you to add .00 to the end of your dollar amount.");
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
                String dispenseLog = product.getProductName() + " " + product.getProductID() + " $" + product.getPrice() + " $" + customerBalance.getBalance();
                logger.log(dispenseLog);
            } else if (customerBalance.getBalance().compareTo(product.getPrice()) == -1) {
                System.out.println("Insufficient funds. Please add more money to complete transaction.");
            }
        }

    }


    public String makeChange(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal noDecimalBalance = (balance.multiply(oneHundred));
            double noDecimalDouble = noDecimalBalance.doubleValue();
            int noDecimalInt = (int) noDecimalDouble;
            int numberOfQuarters = noDecimalInt / QUARTER;
            int balanceAfterQuarters = noDecimalInt - (numberOfQuarters * QUARTER);
            int numberOfDimes = balanceAfterQuarters / DIME;
            int balanceAfterDimes = balanceAfterQuarters - (numberOfDimes * DIME);
            int numberOfNickels = balanceAfterDimes / NICKEL;
            String changeInCoins = "Here's your change! " + numberOfQuarters + (numberOfQuarters == 1 ? " quarter, " : " quarters, ")
                    + numberOfDimes + (numberOfDimes == 1 ? " dime, " : " dimes, ") + numberOfNickels + (numberOfNickels == 1 ? " nickel." : " nickels.");
            System.out.println(changeInCoins);
            String changeLog = "GIVE CHANGE: $" + balance + " " + "$0.00";
            logger.log(changeLog);
            return changeInCoins;
        } else {
            String negativeBalance = "Your balance is negative?! Quick, add more money!";
            return negativeBalance;
        }
    }

    public BigDecimal setBalanceToZero(){
        balance = BigDecimal.ZERO;
        return balance;
    }



}
