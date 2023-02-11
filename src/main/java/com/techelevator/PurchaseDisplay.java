package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class PurchaseDisplay {

    //BigDecimal moneyAddedBD = new BigDecimal("0");
    Scanner input = new Scanner(System.in);

    private VendingMenu menu;
    VendingMachineCLI vendingMachine;
    //getters/setters for financial
    Display display = new Display();
    Inventory inventory = new Inventory();
    Stock stock = new Stock();
    private Map<String, Product> displayInventory = new TreeMap<>();
    String purchaseChoice = "";
    Balance balance = new Balance();
    String [] infoArray;

    public PurchaseDisplay(VendingMenu menu) {
        this.menu = menu;
    }

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
        System.out.println("Current Money Provided: $" + balance.getBalance());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Please choose an option >>> ");
        String purchaseInput = input.nextLine();

        boolean purchaseMenuRunning = true;
        while (purchaseMenuRunning) {


            if (purchaseInput.equals("1")) {
                balance.feedMoney();
                purchaseMenu();
            }else if (purchaseInput.equals("2")) {
                displayItems();
                String idChoice = userPurchaseChoice();
                if (displayInventory.containsKey(idChoice)) {
                    stock.productPurchased(idChoice);
                    //method that subtracts price from balance
//                    inventory.productHashMap.get(idChoice).getSound();
                    //method that logs transaction
                    //method printWriter Sales Report
//                    balance.balanceAfterPurchase(idChoice);
                    purchaseMenu();
                }
            }else if (purchaseInput.equals("3")) {
                //method that give change
                //method to return balance to 0
                //This needs to return to main menu
                purchaseMenuRunning = false;
            }else
                System.out.println("Invalid choice, please type a number 1-3");
            purchaseMenu();
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

 /*   public void reader() {

        File inventoryList = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");
        int remainingSupply;

        System.out.println("Available Inventory:");
        System.out.println();
        System.out.println("Location | Item | Price | Quantity Remaining");
        System.out.println();
        try (Scanner fileInput = new Scanner(inventoryList)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                infoArray = lineOfText.split("\\|");
                for (Map.Entry<String, Product> entry : displayInventory.entrySet()) {
                    remainingSupply = stock.getStockMap().get(entry.getKey());
                    }
                System.out.println(infoArray[0] + " | " + infoArray[1] + " | " + infoArray[2] + " | " + remainingSupply); //TODO Replace testMap() value with actual inventory remaining
            }
        }catch (FileNotFoundException e) {
            System.out.println("damn");
        }
    }*/


}
