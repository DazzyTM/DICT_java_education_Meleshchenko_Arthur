package ChatBot;
import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1st stage
        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in 2023.");

        // 2nd stage
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();
        System.out.println("What a great name you have, " + userName + "!");

        // 3rd stage
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");
        int remainder3 = Integer.parseInt(scanner.nextLine());
        int remainder5 = Integer.parseInt(scanner.nextLine());
        int remainder7 = Integer.parseInt(scanner.nextLine());
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + ", that's a good time to start programming!");

        // 4th stage
        System.out.println("Now I will prove to you that I can count to any number you want");
        System.out.println("Enter a number:");
        int fromNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Counting numbers from " + fromNum);
        for (int number = 0; number <= fromNum; number++) {
            System.out.println(number + "!");
        }
        System.out.println("Completed!");

        // 5th stage
        System.out.println("Let's test your astronomy knowledge.");
        System.out.println("What color is the sun?");
        System.out.println("1. Red\n2. Yellow\n3. Orange\n4. White");
        int answer = 0;
        while (answer != 4) {
            answer = Integer.parseInt(scanner.nextLine());
            if (answer > 4 || answer < 1) {
                System.out.println("Wrong, try again.");
            } else if (answer != 4) {
                System.out.println("Wrong, try again.");
            } else {
                System.out.println("Correct!\nGoodbye, have a nice day!");
            }
        }
    }
}
