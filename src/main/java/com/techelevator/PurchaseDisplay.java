package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class PurchaseDisplay {

    //BigDecimal moneyAddedBD = new BigDecimal("0");
    Scanner input = new Scanner(System.in);
    double balance = 0.00;
    //VendingMachineCLI cli = new VendingMachineCLI();
    //getters/setters for financial
    Display display = new Display();
    Inventory inventory = new Inventory();

    String purchaseChoice = "";

    public double feedMoney() {
        System.out.println("Hungry? Please deposit money (in $1.00 increments) by typing 1.00 and pressing Enter");
        String moneyAdded = input.nextLine();
        if (!moneyAdded.contains(".00")) {
            System.out.println("Please enter in a whole dollar amount. This machine don't do coins.");
            System.out.println("*********");
            return balance;
        } else
            System.out.println("You have added $ " + moneyAdded);
            double monAddDouble = Double.parseDouble(moneyAdded);
            return balance += monAddDouble;
    }

    public void userPurchaseChoice (){
        System.out.println("Please make your selection (ex: B2) :");
        purchaseChoice = input.nextLine();
        if(purchaseChoice.length() != 2){
            System.out.println("Please enter a valid ID");
        }
    }

    public void purchaseMenu(){
        System.out.println("Current Money Provided: $" + balance);
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Please choose an option >>> ");
        String purchaseChoice = input.nextLine();

        boolean purchaseMenuRunning = true;
        while (purchaseMenuRunning) {
            String choice = purchaseChoice;

            switch (choice) {
                case "1":
                    feedMoney();
                    purchaseMenu();
                    break;
                case "2":
                    display.displayBoard();
                    userPurchaseChoice();
                    inventory.makePurchase(purchaseChoice);
                    //userinput to do the search
                    //method takes user input, searches map by ID, returns product.get quantity -1
                    //makePurchase(userinput) // return sound
                    // balance method
                    break;
                case "3":
                    //do transaction
                    purchaseMenuRunning = false;
                    //VendingMachineCLI.run();  TODO back to main menu
                    break;
                default:
                    System.out.println("Invalid choice, please type a number 1-3.");
                    purchaseMenu();
                    break;
            }
        }
    }


}
