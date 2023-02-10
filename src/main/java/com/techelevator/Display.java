package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Display {

    Inventory inventory = new Inventory();
    private  Map<String, Product> displayInventory = inventory.importInformation();
    String[] infoArray;



    public void displayBoard() {       //This works in conjunction with the reader method to make the display if the user chooses option 1
        System.out.println("Available Inventory:");
        System.out.println();
        System.out.println("Location | Item | Price | Quantity Remaining");
        System.out.println();
        displayItems();
    }

    public void reader() {

        File inventoryList = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");

        try (Scanner fileInput = new Scanner(inventoryList)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                infoArray = lineOfText.split("\\|");
                System.out.println(infoArray[0] + " | " + infoArray[1] + " | " + infoArray[2] + " | " + testMap()); //TODO Replace testMap() value with actual inventory remaining
            }
        } catch (FileNotFoundException e) {
            System.out.println("damn");
        }
    }

    public String testMap() {
        String quantityRemaining;
        Map<String, Integer> productDisplayMap = new HashMap();
        productDisplayMap.put(infoArray[0], inventory.productHashMap.get(infoArray[0]).getQuantity()); //TODO set the value to the value of a separate map tracking stock?
        int remainingProduct = productDisplayMap.get(infoArray[0]);
        if (remainingProduct == 0) {
            String soldOut = "SOLD OUT";
            return soldOut;
        }
        quantityRemaining = Integer.toString(remainingProduct);
        return quantityRemaining;

        //make this a 4 each using our already made map
    }

    public void displayItems(){
        String itemMenu = "";

        for(Map.Entry<String, Product> entry: displayInventory.entrySet()) {
            itemMenu = entry.getValue().getProductID() + "|" +
                    entry.getValue().getProductName() + "|" + entry.getValue().getPrice() + "|" + entry.getValue().getQuantity();
            System.out.println(itemMenu);
        }
    }

}
