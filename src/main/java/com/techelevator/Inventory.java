package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

Product product;


    public Map <String, Product> importInformation() {
        Map <String, Product> productHashMap = new HashMap();
        String[] arrayOfText;
        File productInfo = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");
        try (Scanner fileInput = new Scanner(productInfo);) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                arrayOfText = lineOfText.split("\\|");

                if (lineOfText.contains("Chip")) {
                    product = new Chip(arrayOfText[0]);

                } else if (lineOfText.contains("Candy")){
                    product = new Candy(arrayOfText[0]);

                } else if (lineOfText.contains("Drink")){
                    product = new Drink(arrayOfText[0]);

                } else if(lineOfText.contains("Gum")){
                    product = new Gum(arrayOfText[0]);
                }

                product.setProductID(arrayOfText[0]);
                product.setProductName(arrayOfText[1]);
                product.setPrice(BigDecimal.valueOf(Double.parseDouble(arrayOfText[2])));
                product.setTypeOfProduct(arrayOfText[3]);

                productHashMap.put(arrayOfText[0], product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("You dun goofed");
        }

        return productHashMap;
    }
}
