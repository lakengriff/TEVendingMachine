package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Stock extends Inventory{

    private final int MAX_STOCK = 5;
    private int currentStock = MAX_STOCK;

    Map<String, Integer> stockMap = new HashMap();


    public Map<String, Integer> stockingMethod(){

        for(String s : importInformation().keySet()){
            stockMap.put(s, currentStock);
        }
        return stockMap;
    }

    public void productPurchased(String userInputStringWheneverWeGetIt){
        //need more menu info

        currentStock--;
    }
        //TODO need a method that gives ID, Name, currentStock
}
