package org.example;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;


    public User() {
        this.cart = new HashMap<>();
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);
        if (currentQuantity > quantity) {
            cart.put(product, currentQuantity - quantity);
        } else {
            cart.remove(product);
        }
    }

    public void clearCart() {
        cart.clear();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", cart=" + cart + '}';
    }
}