package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {

    public Candy(String productID) {
        super(productID);
    }

    @Override
    public String getSound() {
        return "Munch Munch, Mmm Mmm Good!";
    }
}

