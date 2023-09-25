package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Customer;
import model.Fruit;
import model.FruitShopModel;
import model.OrderItem;
import view.Menu;

public class FruitShopManagement {

    private FruitShopModel model;
    private Menu view;

    public FruitShopManagement(FruitShopModel model, Menu view) {
        this.model = model;
        this.view = view;
    }

    public void createFruit() {
        Scanner scanner = new Scanner(System.in);
        int fruitId = model.getFruits().size() + 1;
        System.out.print("Enter Fruit Name: ");
        String fruitName = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();

        model.createFruit(fruitId, fruitName, price, quantity, origin);
        view.printMessage("Fruit created successfully.");

        System.out.print("Do you want to continue (Y/N)? ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("N")) {
            view.printFruits(model.getFruits());
        }
    }

    public void viewOrders() {
        ArrayList<Customer> customers = model.getCustomers();
        for (Customer customer : customers) {
            view.printOrderSummary(customer);
        }
    }

    public void shopping() {
        Scanner scanner = new Scanner(System.in);
        view.printFruits(model.getFruits());

        System.out.print("Select an item: ");
        int selectedItem = Integer.parseInt(scanner.nextLine());
        Fruit selectedFruit = model.getFruits().get(selectedItem - 1);

        view.printMessage("You selected: " + selectedFruit.getFruitName());

        System.out.print("Please input quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        double amount = selectedFruit.getPrice() * quantity;
        view.printMessage("| Product | Quantity |  Price  |  Amount  |");
        view.printMessage(String.format("|%8s |%10d |%7s |%8s |", selectedFruit.getFruitName(), quantity,
                (selectedFruit.getPrice() + "$"), (amount + "$")));

        System.out.print("Do you want to order now (Y/N)? ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.print("Input your name: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(name);
            OrderItem orderItem = new OrderItem(selectedFruit, quantity);
            customer.addOrderItem(orderItem);
            model.addCustomer(customer);
            view.printMessage("Order placed successfully.");
        } else {
            view.printFruits(model.getFruits());
        }
    }
}
