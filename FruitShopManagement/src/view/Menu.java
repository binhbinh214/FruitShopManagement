package view;

import controller.FruitShopManagement;
import java.util.ArrayList;
import java.util.Scanner;
import model.Customer;
import model.Fruit;
import model.OrderItem;

public class Menu {

    public void printMainMenu() {
        System.out.println("--------------------------------");
        System.out.println("*     FRUIT SHOP MANAGEMENT    *");
        System.out.println("--------------------------------");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyers)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    public void printFruits(ArrayList<Fruit> fruits) {
        System.out.println("--------------------------------");
        System.out.println("|  Item  |    Fruit Name    |   Origin   |   Price   |");
        System.out.println("--------------------------------");
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.printf("|%7d |%15s  |%11s  |%9s  |%n", (i + 1), fruit.getFruitName(), fruit.getOrigin(),
                    (fruit.getPrice() + "$"));
        }
        System.out.println("--------------------------------");
    }

    public void printOrderSummary(Customer customer) {
        System.out.println("--------------------------------");
        System.out.println("| Product  |  Quantity  |  Price  |  Amount  |");
        System.out.println("--------------------------------");
        for (OrderItem item : customer.getOrderItems()) {
            Fruit fruit = item.getFruit();
            System.out.printf("|%9s |%10d |%7s |%8s |%n", fruit.getFruitName(), item.getQuantity(), (fruit.getPrice() + "$"),
                    (item.getTotalAmount() + "$"));
        }
        System.out.println("--------------------------------");
        System.out.println("Total: " + customer.getTotalAmount() + "$");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void runMainMenu(FruitShopManagement controller) {
        while (true) {
            printMainMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    controller.createFruit();
                    break;
                case 2:
                    controller.viewOrders();
                    break;
                case 3:
                    controller.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    printMessage("Invalid choice. Please choose a valid option (1-4).");
            }
        }
    }
}
