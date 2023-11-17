package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static String[] board = {"➖", "➖", "➖", "➖", "➖", "➖", "➖", "➖", "➖"};
    static String currentPlayer = "❌";
    static String winner = null;
    static boolean gameRunning = true;

    public static void main(String[] args) {
        while (gameRunning) {
            printBoard(board);
            if (winner != null) {
                break;
            }
            playerInput(board);
            checkWin();
            checkTie(board);
            switchPlayer();
        }
    }

    static void printBoard(String[] gameBoard) {
        System.out.println(gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
        System.out.println("-".repeat(13));
        System.out.println(gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
        System.out.println("-".repeat(13));
        System.out.println(gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }

    static void playerInput(String[] gameBoard) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentPlayer.equals("❌")) {
                System.out.print("Enter a number 1-9 Player (❌): ");
            } else {
                System.out.print("Enter a number 1-9 Player (⭕): ");
            }
            int inp = scanner.nextInt();
            if (1 <= inp && inp <= 9 && gameBoard[inp - 1].equals("➖")) {
                gameBoard[inp - 1] = currentPlayer;
                break;
            } else {
                if (currentPlayer.equals("❌")) {
                    System.out.println("Oops! Try again! Player - (❌)");
                } else {
                    System.out.println("Oops! Try again! Player - (⭕)");
                }
                printBoard(board);
            }
        }
    }

    static boolean checkHorizontal(String[] gameBoard) {
        for (int i = 0; i < 9; i += 3) {
            if (gameBoard[i].equals(gameBoard[i + 1]) && gameBoard[i].equals(gameBoard[i + 2]) && !gameBoard[i].equals("➖")) {
                winner = currentPlayer;
                return true;
            }
        }
        return false;
    }

    static boolean checkRow(String[] gameBoard) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i].equals(gameBoard[i + 3]) && gameBoard[i].equals(gameBoard[i + 6]) && !gameBoard[i].equals("➖")) {
                winner = currentPlayer;
                return true;
            }
        }
        return false;
    }

    static boolean checkDiagonal(String[] gameBoard) {
        return (gameBoard[0].equals(gameBoard[4]) && gameBoard[0].equals(gameBoard[8]) && !gameBoard[0].equals("➖"))
                || (gameBoard[2].equals(gameBoard[4]) && gameBoard[2].equals(gameBoard[6]) && !gameBoard[2].equals("➖"));
    }

    static void checkWin() {
        if (checkDiagonal(board) || checkHorizontal(board) || checkRow(board)) {
            System.out.println("The winner is " + winner);
        }
    }

    static void checkTie(String[] gameBoard) {
        if (!String.join("", gameBoard).contains("➖")) {
            printBoard(gameBoard);
            System.out.println("It's a tie!");
            gameRunning = false;
        }
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer.equals("❌")) ? "⭕" : "❌";
    }
}
