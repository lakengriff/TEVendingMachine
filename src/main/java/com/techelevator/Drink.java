package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product{

    public Drink(String productID) {
        super(productID);
    }

    @Override
    public void getSound() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
