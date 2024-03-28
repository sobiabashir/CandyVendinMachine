package com.test;

public final class Drinks extends Product{
    private String size;

    public Drinks(double price, String productName, String size) {
        super(price, productName);
        this.size = size;
    }

    @Override
    public String examine() {
        return "Id - " + super.getId() +"  Drink - " + super.getProductName() + ", Size: " + size + ", Price: " + super.getPrice();
    }

    @Override
    public String use() {
        return "Slurp, enjoy your " + getProductName() + "!";
    }
}
