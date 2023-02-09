package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product{

    public Gum(String productID, String productName, BigDecimal price, String typeOfProduct) {
        super(productID, productName, price, typeOfProduct);
    }
    @Override
    public void getSound() {
        System.out.println("Chew Chew, Pop!");
    }
}
