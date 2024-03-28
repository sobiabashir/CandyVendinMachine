package com.test;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine {
    private static int stockrange=10;
    private  final Product[] products;
    private int depositPool;

    public int[] getStock() {
        return stock;
    }

    public void setStock(int[] stock) {
        this.stock = stock;
    }

    private int[] stock;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
        this.stock = new int[products.length];
        initializeStock();
    }


    private void initializeStock() {
        for (int i = 0; i < products.length; i++) {
            stock[i] = stockrange; // Set initial stock level to 10 for each product
        }
    }

    @Override
    public void addCurrency(int amount) {
        if (isValidAmount(amount)) {
            depositPool += amount;
        } else {
            System.out.println();
            System.out.println("Invalid currency amount. Accepted values are: 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000");
        }
    }

    private boolean isValidAmount(int amount) {

       int[] validAmounts = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
            for (int validAmount : validAmounts) {
                if (amount == validAmount) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                if (products[i].getPrice() <= depositPool && stock[i] > 0) {
                    depositPool =depositPool - (int) products[i].getPrice();
                    stock[i]--; // Decrease stock level after purchase
                    return products[i];
                } else {
                    return null; // Product is unavailable or not enough balance
                }
            }
        }
        return null; // Product not found
    }


    @Override
    public int endSession() {
        int balance = depositPool;
        depositPool = 0;
        return balance;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine() ;
            }
        }
        return null;
    }

    @Override
    public String[] getProducts() {
        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productInfo[i] = "ID: " + products[i].getId() + ", Name: " + products[i].getProductName() + ", Price: " + products[i].getPrice() + ", Stock: " + stock[i];
        }
        return productInfo;
    }
}
