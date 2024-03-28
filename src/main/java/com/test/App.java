package com.test;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        Candy candy1 = new Candy(10, "chillimilli", "hot");
        Chips chips1 = new Chips(20, "OLW", "Sour");
        Drinks drink1 = new Drinks(5, "coke", "hot");

        Product[] products = {candy1, chips1, drink1};
        VendingMachine vendingMachine = new VendingMachineImpl(products);
        String[] productsInfo = vendingMachine.getProducts();


        DisplayOfProducts( productsInfo);


        vendingMachine.addCurrency(10); // Initial balance



        System.out.println("Balance is: " + vendingMachine.getBalance());

        System.out.print("Enter the ID of the item you want to purchase: ");
        int requestedId = scanner.nextInt();

        if (vendingMachine.request(requestedId) == null) {
            System.out.println("Requested item is not available or insufficient funds.");
        } else {

            System.out.println("Purchased detail :");
            System.out.println(vendingMachine.getDescription(requestedId));
            System.out.println("Balance is: " + vendingMachine.getBalance());
        }


        vendingMachine.endSession();

        scanner.close();

    }

    private static void DisplayOfProducts(String[] productsInfo){
        System.out.println("********************************************************");
        System.out.println("The list of products : ");
        System.out.println("********************************************************");
        System.out.println();
        for (String product : productsInfo) {
            System.out.println(product);
        }

    }









}
