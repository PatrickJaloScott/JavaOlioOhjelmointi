package model.coffee;

public class CoffeeMaker {
    private boolean isOn;
    public enum CoffeeType {
        NORMAL,
        ESPRESSO
    }
    private CoffeeType coffeeType;
    private int coffeeAmount;
    public static int COFFEEAMOUNTMIN = 10, COFFEEAMOUNTMAX = 80;

    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = CoffeeType.NORMAL;
        this.coffeeAmount = COFFEEAMOUNTMIN;
        printState();
    }

    public void setOn() {
        this.isOn = !this.isOn;
        printState();
    }

    public void setCoffeeType() {
        if(this.isOn) {
            if (this.coffeeType == CoffeeType.NORMAL) {
                this.coffeeType = CoffeeType.ESPRESSO;
            }
            else {
                this.coffeeType = CoffeeType.NORMAL;
            }
        }
        printState();
    }

    public void setCoffeeAmount() {
        if(this.isOn) {
            this.coffeeAmount += 10;
            if(coffeeAmount > COFFEEAMOUNTMAX) {
                this.coffeeAmount = COFFEEAMOUNTMIN;
            }
        }
        printState();
    }

    void printState() {
        String powerState = this.isOn ? "on" : "off";
        System.out.printf("Coffee maker: %s\n", powerState);
        if(this.isOn) {
            System.out.printf("Setting: %s %dml\n", this.coffeeType.toString().toLowerCase(), this.coffeeAmount);
        }
        System.out.println();
    }
}
