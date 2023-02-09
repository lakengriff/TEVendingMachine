package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {




    public void importInformation() {
        String[] arrayOfText;
        File productInfo = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");
        try (Scanner fileInput = new Scanner(productInfo);) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                if (lineOfText.contains("Chip")) {
                    arrayOfText = lineOfText.split("\\|");
                    for (int i = 0; i < arrayOfText.length; i++) {
                        productID = arrayOfText[0];
                        productName = arrayOfText[1];
                        price = Double.parseDouble(arrayOfText[2]);
                        typeOfProduct = arrayOfText[3];

                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("You dun goofed");
        }
    }
}
