package com.test;

public final class Chips extends Product {
    private final String flavor;

    public Chips(double price, String productName, String flavor) {
        super(price, productName);
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "Id - " + super.getId() +"  Chips - " + super.getProductName() + ", Flavor: " + flavor + ", Price: " + super.getPrice();
    }

    @Override
    public String use() {
        return "Crunch crunch, enjoy your " + super.getProductName() + "!";
    }
}
