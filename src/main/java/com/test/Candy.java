package com.test;

public final class Candy extends Product {

        private String flavor;

        public Candy( double price, String productName, String flavor) {
            super( price, productName);
            this.flavor = flavor;
        }

        @Override
        public String examine() {
            return "Id - " + super.getId() + "   Candy - " + super.getProductName() + ", Flavor: " + flavor + ", Price: " + super.getPrice();
        }

        @Override
        public String use() {
            return "Enjoy your " + super.getProductName() + "!";
        }

}
