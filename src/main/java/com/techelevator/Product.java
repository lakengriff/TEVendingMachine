package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private BigDecimal price = new BigDecimal(0.00);
    private String typeOfProduct;
    private int quantity;

    public Product(String productID){
        this.productID = productID;
    }

    public Product(String productID, String productName, BigDecimal price, String typeOfProduct, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
        this.quantity = 5;

    }

    public void dispense(){
        if (quantity > 0){
            this.quantity --;
        }else {
            System.out.println("Not enough supply.");
        }
    }

    public void getSound() {
        System.out.print("");

    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

