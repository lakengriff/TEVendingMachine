package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product{

    public Gum(String productID) {
        super(productID);
    }

    @Override
    public void getSound() {
        System.out.println("Chew Chew, Pop!");
    }
}
