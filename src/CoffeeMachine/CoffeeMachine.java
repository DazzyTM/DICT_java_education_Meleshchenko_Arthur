package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;

        mainMenu();
    }

    public void mainMenu() {
        System.out.println("\n(buy, fill, take, remaining, exit)");
        System.out.print("Select: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    buyAction();
                    break;
                case "fill":
                    fillAction();
                    break;
                case "take":
                    takeAction();
                    break;
                case "remaining":
                    remainingAction();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    mainMenu();
            }
        }
    }

    public void menuReturn() {
        System.out.println();
        mainMenu();
    }

    public boolean checkAction(int[] reduced) {
        String notAvailable = "";
        if (water - reduced[0] < 0) {
            notAvailable = "water";
        } else if (milk - reduced[1] < 0) {
            notAvailable = "milk";
        } else if (coffeeBeans - reduced[2] < 0) {
            notAvailable = "beans";
        } else if (disposableCups - reduced[3] < 0) {
            notAvailable = "cups";
        }

        if (!notAvailable.isEmpty()) {
            System.out.println("Sorry, not enough " + notAvailable + "! 😥");
            return false;
        } else {
            System.out.println("I have enough resources to make you a coffee! 👍");
            return true;
        }
    }

    public void actionStr(int[] reduced) {
        water -= reduced[0];
        milk -= reduced[1];
        coffeeBeans -= reduced[2];
        disposableCups -= reduced[3];
        money += reduced[4];
    }

    public void buyAction() {
        System.out.print("What do you want to buy? \n1 - espresso \n2 - latte \n3 - cappuccino \nexit - to main menu:\n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        int[] reduced;

        switch (choice) {
            case "1" -> {
                reduced = new int[]{250, 0, 16, 1, 4};
                if (checkAction(reduced)) {
                    actionStr(reduced);
                }
            }
            case "2" -> {
                reduced = new int[]{350, 75, 20, 1, 7};
                if (checkAction(reduced)) {
                    actionStr(reduced);
                }
            }
            case "3" -> {
                reduced = new int[]{200, 100, 12, 1, 6};
                if (checkAction(reduced)) {
                    actionStr(reduced);
                }
            }
            case "back" -> menuReturn();
        }
        menuReturn();
    }

    public void fillAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("how many ml of water 🧺 do you want to add:\n");
        water += scanner.nextInt();
        System.out.print("how many ml of milk 🥛 do you want to add::\n");
        milk += scanner.nextInt();
        System.out.print("how many grams of coffee beans ☕ do you want to add:\n");
        coffeeBeans += scanner.nextInt();
        System.out.print("how many disposable cups 🥤 of coffee do you want to add:\n");
        disposableCups += scanner.nextInt();
        menuReturn();
    }

    public void takeAction() {
        System.out.println("I gave you $" + money);
        money = 0;
        menuReturn();
    }

    public void remainingAction() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water 🧺");
        System.out.println(milk + " of milk 🥛");
        System.out.println(coffeeBeans + " of coffee beans ☕");
        System.out.println(disposableCups + " of disposable cups 🥤");
        System.out.println("$" + money + " of money 💵");
        menuReturn();
    }

    public static void main(String[] args) {
        new CoffeeMachine(400, 540, 120, 9, 550).mainMenu();
    }
}
