package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Stock extends Inventory{


    private int startingStock = 5;

    Map<String, Integer> stockMap = new HashMap<>();

    //map 2

    public void stockingMethod(){

        for(String s : importInformation().keySet()){
            this.stockMap.put(s, startingStock);
        }

    }

    public void productPurchased(String userInput){

        for (String id :getStockMap().keySet()) {
            if (userInput.equals(id)) {
                int updatedStock = stockMap.get(id);
                this.stockMap.replace(id, updatedStock - 1);
                break;
            }
        }
    }

    public Map<String, Integer> getStockMap() {
        return this.stockMap;
    }
//    public void makePurchase(String userInput) {
//        //if product doesnt exist // return to purchase menu
//        //inform customer if sold out
//        //if they select valid product, it is dispensed and sout sound.
//        for (String id :getStockMap().keySet()) {
//            if (userInput.equals(id)) {
//                getStockMap().replace(userInput, getStockMap().get(userInput) - 1);
//                System.out.println(getStockMap().get(userInput));
//            }
//        }
//    }

//TODO need a method that gives ID, Name, currentStock
}
