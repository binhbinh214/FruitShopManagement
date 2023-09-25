package model;

public class OrderItem {

    private Fruit fruit;
    private int quantity;

    public OrderItem(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return fruit.getPrice() * quantity;
    }
}
