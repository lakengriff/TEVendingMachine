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


    public Product(String productID, String productName, BigDecimal price, String typeOfProduct) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.typeOfProduct = typeOfProduct;

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
}

