package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product{

    public Drink(String productID, String productName, BigDecimal price, String typeOfProduct) {
        super(productID, productName, price, typeOfProduct);
    }
    @Override
    public void getSound() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
