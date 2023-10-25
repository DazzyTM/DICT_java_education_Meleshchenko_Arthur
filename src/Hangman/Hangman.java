package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        String exit = "exit";
        System.out.println("Type 'play' to play the game, 'exit' to quit");
        Scanner scanner = new Scanner(System.in);
        String choiceInput = scanner.nextLine();
        if (choiceInput.equals(exit)) {
            System.exit(0);
        }

        String[] wordlist = {"python", "java", "javascript", "php"};
        Random random = new Random();
        String secret = wordlist[random.nextInt(wordlist.length)];
        int tries = 8;
        StringBuilder guesses = new StringBuilder();
        boolean done = false;

        while (!done) {
            System.out.println("Tries: " + tries);
            for (char letter : secret.toCharArray()) {
                if (guesses.toString().toLowerCase().contains(String.valueOf(letter))) {
                    System.out.print(letter + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();

            System.out.print("Input a letter: ");
            String input = scanner.next().toLowerCase();

            if (input.length() != 1 || !Character.isLowerCase(input.charAt(0))) {
                System.out.println("Please enter a valid lowercase English letter.");
            } else {
                char guess = input.charAt(0);
                if (guesses.indexOf(String.valueOf(guess)) != -1) {
                    System.out.println("You already guessed that letter. Try a different one.");
                } else {
                    guesses.append(guess);
                    if (secret.indexOf(guess) == -1) {
                        System.out.println("That letter doesn't appear in the word");
                        tries--;
                        if (tries == 0) {
                            break;
                        }
                    }

                    done = true;
                    for (char letter : secret.toCharArray()) {
                        if (guesses.toString().toLowerCase().indexOf(letter) == -1) {
                            done = false;
                            break;
                        }
                    }
                }
            }
        }

        if (done) {
            System.out.println("You survived!");
        } else {
            System.out.println("Game over! The word was " + secret  + "!");
        }
    }
}
