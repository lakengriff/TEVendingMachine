package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String productID) {
        super(productID);
    }
    @Override
    public void getSound() {
        System.out.println("Munch Munch, Mmm Mmm Good!");
    }
}
