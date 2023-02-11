package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product{

    public Drink(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {
        super(productID, productName, price, typeOfProduct, quantity);
    }
    @Override
    public String getSound() {
        return "Glug Glug, Chug Chug!";
    }
}
