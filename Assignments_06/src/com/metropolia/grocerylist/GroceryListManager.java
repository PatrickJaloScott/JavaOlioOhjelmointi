package com.metropolia.grocerylist;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListManager {
    private static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        addItem("Apples");
        addItem("Milk");
        addItem("Bread");

        displayList();
        System.out.println("Is Milk in the grocery list? " + checkItem("Milk"));

        removeItem("Milk");
        displayList();

        input.close();
    }

    public static void addItem(String item) {
        groceryList.add(item);
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

    public static boolean checkItem(String item) {
        return groceryList.contains(item);
    }
}
