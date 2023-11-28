package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product(1, "Milk", 35);
        Product bread = new Product(2, "Light Bread", 25);
        Product potato = new Product(10, "Potato", 11);

        Cart firstCart = new Cart();

        firstCart.addProduct(milk);
        firstCart.addProduct(potato);
        firstCart.removeProduct(potato);
        firstCart.addProduct(bread);

        Order firstOrder = new Order(1, firstCart.products);
        firstOrder.setStatus("Work");

        System.out.println(firstOrder.getStatus());
    }
}