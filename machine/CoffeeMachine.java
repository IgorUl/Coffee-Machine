package machine;


import java.util.Scanner;

public class CoffeeMachine {
    Scanner sc = new Scanner(System.in);
    boolean warn = true;

    int water = 400;
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
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(sc.nextLine());
        warn = true;

    }

    public void check(String str) {
        switch (str) {
            case "espresso":
                warning(250, "water");
                warning(16, "coffee beans");
                warning(1, "disposable cups");
                if (warn) {
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "latte":
                warning(350, "water");
                warning(75, "milk");
                warning(20, "coffee beans");
                warning(1, "disposable cups");
                if (warn) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "cappuccino":
                warning(200, "water");
                warning(100, "milk");
                warning(12, "coffee beans");
                warning(1, "disposable cups");
                if (warn) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

        }
    }

    public void warning(int j, String str) {

        switch (str) {
            case "water":
                if (water < j) {
                    System.out.println("Sorry, not enough " + str + "!");
                    warn = false;
                }
                break;
            case "milk":
                if (milk < j) {
                    System.out.println("Sorry, not enough " + str + "!");
                    warn = false;
                }
                break;
            case "coffee beans":
                if (beans < j) {
                    System.out.println("Sorry, not enough " + str + "!");
                    warn = false;
                }
                break;
            case "disposable cups":
                if (cups < j) {
                    System.out.println("Sorry, not enough " + str + "!");
                    warn = false;
                }
                break;
        }
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (sc.nextLine()) {
            case "1":
                check("espresso");
                break;
            case "2":
                check("latte");
                break;
            case "3":
                check("cappuccino");
                break;
            default:
                break;
        }
    }

    public void initMachine() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
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
                case "remaining":
                    printStatus();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
        machine.initMachine();
    }

}

