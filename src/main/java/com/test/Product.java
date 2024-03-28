package com.test;

import java.util.UUID;

public abstract class Product {

        private static int productSequenceId=0;
        private int id;
        private double price;
        private String productName;

        ///////////getter setter
        public int getId() {
        return id;
        }
        public String getProductName() {
        return productName;
        }
        public double getPrice() {
        return price;
        }

        public void setPrice(double price) {
        this.price = price;
        }

        public void setProductName(String productName) {
        this.productName = productName;
        }

    public Product(double price, String productName) {
            id=++productSequenceId;
            this.price = price;
            this.productName = productName;
        }

        public abstract String examine();

        public abstract String use();

}
