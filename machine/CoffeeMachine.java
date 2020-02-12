package machine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner sc = new Scanner(System.in);

    int water = 1200;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();

    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (sc.nextInt()) {
            case 1:
                water -= 250;
                beans -= 16;
                money += 4;
                cups--;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                beans -=20;
                money += 7;
                cups--;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cups--;
                break;
        }
    }

    public void initMachine() {
        printStatus();
        System.out.print("\n");
        System.out.println("Write action (buy, fill, take):");
        switch (sc.nextLine()) {
            case "fill":
                fill();
                break;
            case "buy":
                buy();
                break;
            case "take":
                take();
                break;
        }
        System.out.print("\n");
        printStatus();
    }


    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
        machine.initMachine();
    }

}

