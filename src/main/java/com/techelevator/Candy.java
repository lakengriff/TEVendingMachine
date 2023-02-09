package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String productID, String productName, BigDecimal price, String typeOfProduct) {
        super(productID, productName, price, typeOfProduct);
    }
    @Override
    public void getSound() {
        System.out.println("Munch Munch, Mmm Mmm Good!");
    }
}
