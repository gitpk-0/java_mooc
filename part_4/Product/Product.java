/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pk
 */
public class Product {

    private double price;
    private int quantity;
    private String name;


    // Product constructor
    public Product(String initialName, double initialPrice, int initialQuantity) {
        this.price = initialPrice;
        this.quantity = initialQuantity;
        this.name = initialName;
    }

    // methods
    public void printProduct() {
        System.out.println(name + ", " + "price" + " " + price + ", " + quantity + " pcs");
    }
    
}
