package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class PurchaseDisplay {

    //BigDecimal moneyAddedBD = new BigDecimal("0");
    Scanner input = new Scanner(System.in);

    //VendingMachineCLI cli = new VendingMachineCLI();
    //getters/setters for financial
    Display display = new Display();
    Inventory inventory = new Inventory();
    Stock stock = new Stock();
    private Map<String, Product> displayInventory = new HashMap<>();
    String purchaseChoice = "";
    Balance balance = new Balance();
    public PurchaseDisplay() {
        displayInventory = inventory.importInformation();
        stock.stockingMethod();
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
        System.out.println("Current Money Provided: $" + balance.feedMoney());
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
                    balance.feedMoney();
                    purchaseMenu();
                    break;
                case "2":
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
        System.out.println("Available Inventory:");
        System.out.println();
        System.out.println("Location | Item | Price | Quantity Remaining");
        System.out.println();
        for(Map.Entry<String, Product> entry: displayInventory.entrySet()) {
            String itemMenu = entry.getValue().getProductID() + "|" +
                    entry.getValue().getProductName() + "|" + entry.getValue().getPrice() + "|" + stock.getStockMap().get(entry.getKey());

            System.out.println(itemMenu);
        }
    }


}
