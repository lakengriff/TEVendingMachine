package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product {

    public Candy(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {
        super(productID, productName, price, typeOfProduct, quantity);
    }
    @Override
    public String getSound() {
        return "Munch Munch, Mmm Mmm Good!";
    }
}

