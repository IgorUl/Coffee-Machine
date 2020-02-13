package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Machine machine = new Machine();


        while (true) {
            if (machine.status == States.ACTION) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                machine.userInput(sc.nextLine());
            } else if (machine.status == States.BUY) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                machine.userInput(sc.nextLine());
            } else if (machine.status == States.FILLWATER) {
                System.out.println("Write how many ml of water do you want to add:");
                machine.userInput(sc.nextLine());
                System.out.println("Write how many ml of milk do you want to add:");
                machine.userInput(sc.nextLine());
                System.out.println("Write how many grams of coffee beans do you want to add:");
                machine.userInput(sc.nextLine());
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                machine.userInput(sc.nextLine());
            }
        }
    }
}
