import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    // Display the board
    static void displayBoard() {
        System.out.println();
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println();
    }

    // Check whether a player has won
    static boolean checkWinner(char player) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Check whether the board is full
    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    // Reset the board for a new round
    static void resetBoard() {
        char number = '1';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = number++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("===== TIC-TAC-TOE GAME =====");

        while (playAgain) {

            resetBoard();

            char currentPlayer = 'X';

            while (true) {

                displayBoard();

                System.out.print("Player " + currentPlayer +
                                 ", enter a position (1-9): ");

                // Validate numeric input
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number from 1 to 9.");
                    sc.next();
                    continue;
                }

                int position = sc.nextInt();

                // Validate position
                if (position < 1 || position > 9) {
                    System.out.println("Invalid position! Choose a number from 1 to 9.");
                    continue;
                }

                // Convert position to row and column
                int row = (position - 1) / 3;
                int column = (position - 1) % 3;

                // Check whether position is already occupied
                if (board[row][column] == 'X' ||
                    board[row][column] == 'O') {

                    System.out.println("That position is already occupied!");
                    continue;
                }

                // Place player's symbol
                board[row][column] = currentPlayer;

                // Check winner
                if (checkWinner(currentPlayer)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check draw
                if (isDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // Change player
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }

            // Ask for another round
            System.out.print("Do you want to play another round? (Y/N): ");
            String answer = sc.next();

            while (!answer.equalsIgnoreCase("Y") &&
                   !answer.equalsIgnoreCase("N")) {

                System.out.print("Invalid input! Please enter Y or N: ");
                answer = sc.next();
            }

            if (answer.equalsIgnoreCase("N")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
        sc.close();
    }
}