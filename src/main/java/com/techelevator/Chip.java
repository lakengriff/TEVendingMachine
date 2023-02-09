package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{

    public Chip(String productID, String productName, BigDecimal price, String typeOfProduct) {
        super(productID, productName, price, typeOfProduct);
    }
    @Override
    public void getSound() {
        System.out.println("Crunch Crunch, It's Yummy!");
    }

    }

