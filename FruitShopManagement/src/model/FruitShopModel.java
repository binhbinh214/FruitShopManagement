package model;

import java.util.ArrayList;

public class FruitShopModel {

    private ArrayList<Fruit> fruits;
    private ArrayList<Customer> customers;

    public FruitShopModel() {
        fruits = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void createFruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        fruits.add(fruit);
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
