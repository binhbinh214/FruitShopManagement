package model;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<OrderItem> orderItems;

    public Customer(String name) {
        this.name = name;
        this.orderItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (OrderItem item : orderItems) {
            totalAmount += item.getTotalAmount();
        }
        return totalAmount;
    }
}
