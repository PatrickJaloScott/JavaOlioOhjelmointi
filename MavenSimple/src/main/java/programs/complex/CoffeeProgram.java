package programs.complex;

import model.coffee.CoffeeMaker;
import ui.UserInterface;

public class CoffeeProgram {
    public static void main(String[] args) {
        CoffeeMaker moccaMaster = new CoffeeMaker();

        String syotto;
        do {
            System.out.println("[o]On/Off, [t]Coffee Type, [a]Amount +10, [x]Exit program");
            syotto = UserInterface.promptStringInput("[o]On/Off, [t]Coffee Type, [a]Amount +10, [x]Exit program");
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
    }
}
