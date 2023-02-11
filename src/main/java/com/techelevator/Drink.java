package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product{

    public Drink(String productID) {
        super(productID);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Chug Chug!";
    }
}
