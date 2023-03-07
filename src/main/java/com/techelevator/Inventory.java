package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    public Map<String, Product> importInformation() {

        Map<String, Product> productHashMap = new LinkedHashMap<>();
        String[] arrayOfText;
        File productInfo = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");
        try (Scanner fileInput = new Scanner(productInfo);) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                arrayOfText = lineOfText.split("\\|");

                if (lineOfText.contains("Chip")) {
                    Product product = new Chip(arrayOfText[0], arrayOfText[1], new BigDecimal(arrayOfText[2]), arrayOfText[3], 5);
                    productHashMap.put(arrayOfText[0], product);

                } else if (lineOfText.contains("Candy")) {
                    Product product = new Candy(arrayOfText[0], arrayOfText[1], new BigDecimal(arrayOfText[2]), arrayOfText[3], 5);
                    productHashMap.put(arrayOfText[0], product);

                } else if (lineOfText.contains("Drink")) {
                    Product product = new Drink(arrayOfText[0], arrayOfText[1], new BigDecimal(arrayOfText[2]), arrayOfText[3], 5);
                    productHashMap.put(arrayOfText[0], product);

                } else if (lineOfText.contains("Gum")) {
                    Product product = new Gum(arrayOfText[0], arrayOfText[1], new BigDecimal(arrayOfText[2]), arrayOfText[3], 5);
                    productHashMap.put(arrayOfText[0], product);

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("You dun goofed");
        }

        return productHashMap;
    }

    public void displayItems(Map<String, Product> inventoryMap){
        System.out.println("Available Inventory:");
        System.out.println();
        System.out.println("Location | Item | Price | Quantity Remaining");
        System.out.println();
        for(Map.Entry<String, Product> entry: inventoryMap.entrySet()) {
            String itemMenu = entry.getKey() + "|" +
                    entry.getValue().getProductName() + "|" + entry.getValue().getPrice() + "|" + ((entry.getValue().getQuantity() == 0) ? "SOLD OUT" : entry.getValue().getQuantity());

            System.out.println(itemMenu);
        }
    }

}