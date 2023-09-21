package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.ShoppingList;

public class GroceryListManager {
    private static ArrayList<String> groceryList = new ArrayList<>();
    private static HashMap<String, Double> pricedGroceryList = new HashMap<>();
    private static HashMap<String, String> categorizedGroceryList = new HashMap<>();
    private static HashMap<String, Integer> quantifiedGroceryList = new HashMap<>();

    public static void main(String[] args) {
        // task 1
        addItem("Apples");
        addItem("Milk");
        addItem("Bread");
        displayList();
        System.out.println("Is Milk in the grocery list? " + checkItem("Milk"));

        removeItem("Milk");
        displayList();
        // task 2
        System.out.println("\nCosts");
        addItem("Apples", 2.30);
        addItem("Milk", 3.99);
        addItem("Bread", 2.15);

        System.out.println("Items total cost: " + calculateTotalCost() + " €");

        // task 3
        System.out.println("\nCategories");
        addItemWithCategory("Apples", "fruit");
        addItemWithCategory("Milk", "dairy");
        addItemWithCategory("Bread", "bakery");
        addItemWithCategory("Oranges", "fruit");
        addItemWithCategory("Yoghurt", "dairy");
        addItemWithCategory("Pastries", "bakery");

        displayByCategory("fruit");
        displayByCategory("dairy");
        displayByCategory("bakery");

        // task 4
        System.out.println("\nQuantity");
        addItemWithQuantity("Apples", 20);
        addItemWithQuantity("Milk", 5);
        addItemWithQuantity("Bread", 7);
        displayAvailableItems();
        System.out.println("\tUpdating quantity of items");
        updateQuantity("Apples", 10);
        updateQuantity("Milk", 1);
        updateQuantity("Bread", 0);
        displayAvailableItems();

        // Task 5
        System.out.println("\nUsing shopping list class");
        ShoppingList bbq = new ShoppingList("Backyard BBQ"),
        camping = new ShoppingList("Weekend Camping");
        bbq.addItem("Beef patties", 5.45, "Meat", 10);
        bbq.addItem("Sausages", 3.88, "meat", 15);
        bbq.addItem("Hamburger buns", 2.25, "breads", 20);
        bbq.addItem("Hotdog buns", 2.3, "breads", 20);
        bbq.addItem("Hamburger sauce", 3.45, "sAuces", 3);
        bbq.addItem("Ketchup", 3.30, "sauces", 3);
        bbq.displayList("meat");
        bbq.displayList("sauces");
        bbq.displayQuantifiedPrices();
        camping.addItem("Kettle", 28.75, "camping equipment", 3);
        camping.addItem("Gaming console", 119.99, "electronics", 2);
        camping.addItem("Tent", 49.99, "camping equipment", 2);
        camping.displayList();
        camping.removeItem("Gaming console");
        camping.displayList();
    }

    public static void addItem(String item) {
        groceryList.add(item);
    }

    public static void addItem(String item, double cost) {
        pricedGroceryList.put(item, cost);
    }

    public static void addItemWithCategory(String item, String category) {
        categorizedGroceryList.put(item, category);
    }

    public static void addItemWithQuantity(String item, int quantity) {
        quantifiedGroceryList.put(item, quantity);
    }

    public static void updateQuantity(String item, int newQuantity) {
        quantifiedGroceryList.put(item, newQuantity);
    }

    public static void removeItem(String item) {
        System.out.println("Removing " + item + " from the list...");
        groceryList.remove(item);
    }

    public static void displayList() {
        System.out.println("Grocery List:");
        for (String s : groceryList) {
            System.out.println(groceryList.indexOf(s)+1 + ". " + s);
        }
        System.out.println();
    }

    public static void displayByCategory(String category) {
        System.out.println("Displaying items of category: " + category);
        for (Map.Entry<String, String> entry : categorizedGroceryList.entrySet()) {
            if (entry.getValue().equals(category)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void displayAvailableItems() {
        for (Map.Entry<String, Integer> entry : quantifiedGroceryList.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " kpl");
            }
        }
    }

    public static boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static double calculateTotalCost() {
        double totalCost = 0;
        for (Map.Entry<String, Double> entry : pricedGroceryList.entrySet()) {
            totalCost += entry.getValue();
        }
        return totalCost;
    }
}
