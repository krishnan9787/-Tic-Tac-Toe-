import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC5{

    static char[][] board = new char[3][3];
    static char humanSymbol;
    static char computerSymbol;
    static String currentPlayer;
    static Scanner scanner = new Scanner(System.in);

    // UC1: Initialize the board with '-'
    static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC1: Print the board
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // UC2: Toss to decide first player and assign symbols
    static void toss() {
        Random rand = new Random();
        int result = rand.nextInt(2);

        if (result == 0) {
            currentPlayer = "human";
            humanSymbol = 'X';
            computerSymbol = 'O';
            System.out.println("🎉 You won the toss! You play first as X.");
        } else {
            currentPlayer = "computer";
            computerSymbol = 'X';
            humanSymbol = 'O';
            System.out.println("💻 Computer won the toss! Computer plays first as X.");
        }

        System.out.println("Your symbol    : " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }

    // UC3: Accept user slot input (1–9)
    static int getUserInput() {
        System.out.print("Enter your slot (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    // UC4: Convert slot number to row index
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // UC4: Convert slot number to column index
    static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // UC5: Validate the move
    static boolean isValidMove(int row, int col) {
        // Check boundary
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("❌ Invalid slot! Please enter a number between 1 and 9.");
            return false;
        }
        // Check if cell is already occupied
        if (board[row][col] != '-') {
            System.out.println("❌ That slot is already taken! Choose another.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        initBoard();
        printBoard();
        toss();

        // Test UC3 + UC4 + UC5
        int slot = getUserInput();
        int row = getRow(slot);
        int col = getCol(slot);

        if (isValidMove(row, col)) {
            System.out.println("✅ Valid move! Slot " + slot + " → board[" + row + "][" + col + "]");
        }
    }
}