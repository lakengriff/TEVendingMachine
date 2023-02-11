package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product{

    public Gum(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {
        super(productID, productName, price, typeOfProduct, quantity);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Pop!";
    }
}
