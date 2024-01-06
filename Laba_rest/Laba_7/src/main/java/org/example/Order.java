package org.example;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;


    public Order() {
        this.orderDetails = new HashMap<>();
        calculateTotalPrice();
    }

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        calculateTotalPrice();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<Product, Integer> orderDetails) {
        this.orderDetails = orderDetails;
        calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public void calculateTotalPrice() {
        this.totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +  "id=" + id +  ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + '}';
    }
}
