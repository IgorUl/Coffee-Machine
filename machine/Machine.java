package machine;

public class Machine {
    boolean warn = true;
    States status = States.ACTION;

    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    public void printStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void fillWater(String str) {
        water += Integer.parseInt(str);
        warn = true;
    }

    public void fillMilk(String str) {
        milk += Integer.parseInt(str);
        warn = true;
    }

    public void fillBeans(String str) {
        beans += Integer.parseInt(str);
        warn = true;
    }

    public void fillCups(String str) {
        cups += Integer.parseInt(str);
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
                    System.out.print("I have enough resources, making you a coffee!\n");
                }
                break;

        }
    }

    public void warning(int j, String str) {

        switch (str) {
            case "water":
                if (water < j) {
                    System.out.print("Sorry, not enough " + str + "!\n");
                    warn = false;
                }
                break;
            case "milk":
                if (milk < j) {
                    System.out.print("Sorry, not enough " + str + "!\n");
                    warn = false;
                }
                break;
            case "coffee beans":
                if (beans < j) {
                    System.out.print("Sorry, not enough " + str + "!\n");
                    warn = false;
                }
                break;
            case "disposable cups":
                if (cups < j) {
                    System.out.print("Sorry, not enough " + str + "!\n");
                    warn = false;
                }
                break;
        }
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void buy(String str) {

        switch (str) {
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

    public void userInput(String str) {
        switch (status) {
            case ACTION:
                initAction(str);
                break;
            case BUY:
                buy(str);
                status = States.ACTION;
                break;
            case FILLWATER:
                fillWater(str);
                status = States.FILLMILK;
                break;
            case FILLMILK:
                fillMilk(str);
                status = States.FILLBEANS;
                break;
            case FILLBEANS:
                fillBeans(str);
                status = States.FILLCUPS;
                break;
            case FILLCUPS:
                fillCups(str);
                status = States.ACTION;
        }
    }

    public void initAction(String str) {

        switch (str) {
            case "fill":
                status = States.FILLWATER;
                break;
            case "buy":
                status = States.BUY;

                break;
            case "take":
                status = States.ACTION;
                take();
                break;
            case "remaining":
                status = States.ACTION;
                printStatus();
                break;
            case "exit":
                System.exit(0);
                break;
        }
        System.out.print("\n");
    }
}
