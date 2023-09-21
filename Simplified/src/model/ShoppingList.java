package model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingList {
    private String listName;
    private HashMap<String, Double> priceList = new HashMap<>();
    private HashMap<String, String> categories = new HashMap<>();
    private HashMap<String, Integer> quantities = new HashMap<>();

    public ShoppingList(String name) {
        this.listName = name;
    }

    public void addItem(String item, double cost, String category, int quantity) {
        priceList.put(item, cost);
        categories.put(item, category.toLowerCase());
        quantities.put(item, quantity);
    }

    public void removeItem(String item) {
        System.out.println("Removing " + item);
        priceList.remove(item);
        categories.remove(item);
        quantities.remove(item);
    }

    public void displayList() {
        System.out.println("\nFull list (" + listName + ")");
        for (Map.Entry<String, Double> entry : priceList.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void displayQuantifiedPrices() {
        System.out.println("\nFull list (" + listName + ") with total prices");
        double totalPrice = 0;
        for (Map.Entry<String, Double> entry : priceList.entrySet()) {
            int quantity = quantities.get(entry.getKey());
            double price = quantity * priceList.get(entry.getKey());
            totalPrice += price;
            System.out.printf("- %s %.2f€\n", entry.getKey(), price);
        }
        System.out.println("Total price is: " + totalPrice);
    }

    public void displayList(String category) {
        System.out.println("\nList (" + listName + ") by category: " + category);
        for (Map.Entry<String, String> entry : categories.entrySet()) {
            if(entry.getValue().equals(category)) {
                int quantity = quantities.get(entry.getKey());
                double price = priceList.get(entry.getKey());
                System.out.println("- " + entry.getKey() + " " + price + "€ x" + quantity + " kpl");
            }
        }
    }
}
