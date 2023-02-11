package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{

    public Chip(String productID) {
        super(productID);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, It's Yummy!";
    }

    }

