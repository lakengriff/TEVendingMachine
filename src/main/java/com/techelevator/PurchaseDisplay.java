package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PurchaseDisplay {

    //BigDecimal moneyAddedBD = new BigDecimal("0");
    Scanner input = new Scanner(System.in);
    double test = 0.00;
    //VendingMachineCLI cli = new VendingMachineCLI();


    public double feedMoney() {
        System.out.println("Hungry? Please deposit money (in $1.00 increments) by typing 1.00 and pressing Enter");
        String moneyAdded = input.nextLine();
        if (!moneyAdded.contains(".00")) {
            System.out.println("Please enter in a whole dollar amount. This machine don't do coins.");
            System.out.println("*********");
            return test;
        } else
            System.out.println("You have added $ " + moneyAdded);
            double monAddDouble = Double.parseDouble(moneyAdded);
            return test += monAddDouble;
    }

    public void purchaseMenu(){
        System.out.println("Current Money Provided: $" + test);
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
                    //select product
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
