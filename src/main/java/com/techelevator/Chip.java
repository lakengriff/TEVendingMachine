package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{


    public Chip(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {
        super(productID, productName, price, typeOfProduct, quantity);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, It's Yummy!";
    }

    }

