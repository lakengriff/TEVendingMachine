package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class PurchaseDisplay {

    //BigDecimal moneyAddedBD = new BigDecimal("0");
    Scanner input = new Scanner(System.in);
    double balance = 0.00;
    //VendingMachineCLI cli = new VendingMachineCLI();
    //getters/setters for financial
    Display display = new Display();
    Inventory inventory = new Inventory();
    Stock stock = new Stock();
    private Map<String, Product> displayInventory = new HashMap<>();
    String purchaseChoice = "";

    public PurchaseDisplay() {
        displayInventory = inventory.importInformation();
        stock.stockingMethod();
    }

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

    public String userPurchaseChoice (){
        System.out.println("Please make your selection (ex: B2) :");
        purchaseChoice = input.nextLine();
        if(purchaseChoice.length() != 2){
            System.out.println("Please enter a valid ID");
        }
        return purchaseChoice;
    }

    public void purchaseMenu(){
        System.out.println("Current Money Provided: $" + balance);
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Please choose an option >>> ");
        String purchaseInput = input.nextLine();

        boolean purchaseMenuRunning = true;
        while (purchaseMenuRunning) {


            switch (purchaseInput) {
                case "1":
                    feedMoney();
                    purchaseMenu();
                    break;
                case "2":
                    display.displayBoard();
                    displayItems();
                    String idChoice = userPurchaseChoice();
                    if(displayInventory.containsKey(idChoice)) {
                        stock.productPurchased(idChoice);
                    }
                    purchaseMenu();


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


    public void displayItems(){
        for(Map.Entry<String, Product> entry: displayInventory.entrySet()) {
            String itemMenu = entry.getValue().getProductID() + "|" +
                    entry.getValue().getProductName() + "|" + entry.getValue().getPrice() + "|" + stock.getStockMap().get(entry.getKey());

            System.out.println(itemMenu);
        }
    }


}
