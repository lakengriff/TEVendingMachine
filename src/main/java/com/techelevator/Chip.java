package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{

    public Chip(String productID) {
        super(productID);
    }

    @Override
    public void getSound() {
        System.out.println("Crunch Crunch, It's Yummy!");
    }

    }

