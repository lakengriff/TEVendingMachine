package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Display {

    Inventory inventory = new Inventory();


    private  Map<String, Product> displayInventory = new HashMap<>();
    String[] infoArray;

    public Display() {
        displayInventory = inventory.importInformation();
    }

    public void displayBoard() {       //This works in conjunction with the reader method to make the display if the user chooses option 1
        System.out.println("Available Inventory:");
        System.out.println();
        System.out.println("Location | Item | Price | Quantity Remaining");
        System.out.println();
//        displayItems();
    }

//    public String testMap() {
//        String quantityRemaining;
//        Map<String, Integer> productDisplayMap = new HashMap();
//        productDisplayMap.put(infoArray[0], inventory.productHashMap.get(infoArray[0]).getQuantity()); //TODO set the value to the value of a separate map tracking stock?
//        int remainingProduct = productDisplayMap.get(infoArray[0]);
//        if (remainingProduct == 0) {
//            String soldOut = "SOLD OUT";
//            return soldOut;
//        }
//        quantityRemaining = Integer.toString(remainingProduct);
//        return quantityRemaining;
//
//        //make this a 4 each using our already made map
//    }

//    public void displayItems(){
//
//
//        for(Map.Entry<String, Product> entry: displayInventory.entrySet()) {
//            String itemMenu = entry.getValue().getProductID() + "|" +
//                    entry.getValue().getProductName() + "|" + entry.getValue().getPrice() + "|" + stock.getStockMap().get(entry.getKey());
//
//            System.out.println(itemMenu);
//        }
//    }

}

