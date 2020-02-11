package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = sc.nextInt();
        int water = 200;
        int milk = 50;
        int beans = 15;
        System.out.println("For " + numCups + " cups of coffee you will need:");
        System.out.println(water * numCups + " ml of water");
        System.out.println(milk * numCups + " ml of milk");
        System.out.println(beans * numCups + " g of coffee beans");
    }
}