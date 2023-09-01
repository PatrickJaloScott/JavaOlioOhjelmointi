package com.metropolia.coffee;

import java.util.Scanner;

public class CoffeeProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMaker moccaMaster = new CoffeeMaker();

        String syotto;
        do {
            System.out.println("[o]On/Off, [t]Coffee Type, [a]Amount +10, [x]Exit program");
            syotto = input.nextLine();
            switch (syotto) {
                case "o":
                    moccaMaster.setOn();
                    break;
                case "t":
                    moccaMaster.setCoffeeType();
                    break;
                case "a":
                    moccaMaster.setCoffeeAmount();
                    break;
            }
        } while (!syotto.equalsIgnoreCase("x"));

        input.close();
    }
}
