import java.util.Random;

public class TicTacToeUC2 {

    static char[][] board = new char[3][3];

    static char humanSymbol;
    static char computerSymbol;
    static String currentPlayer; // "human" or "computer"

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
        int result = rand.nextInt(2); // 0 or 1

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

        System.out.println("Your symbol  : " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }

    public static void main(String[] args) {
        initBoard();
        printBoard();
        toss();
    }
}