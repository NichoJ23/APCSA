/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */

import java.util.Scanner;

public class NoTakTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String response;
        do {
            System.out.println('\u000C');
            playGame(input);
            System.out.println("Play again? (y/n)");
            response = input.nextLine().strip().toLowerCase();
        } while (!response.equals("n"));
        
        
    }
    
    void playGame(Scanner input) {
        Board[] boards = new Board[2];
        initializeBoards(boards);
        
        printBoards(boards);
        
        int playerTurn = 1;
        boolean gameOver = false;
        while (!gameOver) {
            playTurn(playerTurn, input, boards);
            gameOver = checkWin(board); // start here
            playerTurn = playerTurn % 2 + 1;
        }
        
        System.out.println("Player " + playerTurn + " wins!");
    }
    
    void playTurn(int turn, Scanner input, String[][] board) {
        System.out.println("Player " + turn + " turn (row, col):");
        
        int row;
        int col;
        boolean repeat = false;
        do {
            repeat = false;
            String playerInput = input.nextLine().strip();
            row = Integer.valueOf(playerInput.charAt(0))-49;
            col = Integer.valueOf(playerInput.charAt(playerInput.length()-1))-49;
            
            if (row < 0 || row > 2) {
                System.out.println("Play in row 1, 2, or 3");
                repeat = true;
            }
            if (col < 0 || col > 2) {
                System.out.println("Play in col 1, 2, or 3");
                repeat = true;
            }
        } while (repeat);
        
        if (board[row][col].equals(" ")) {
            board[row][col] = "X";
        } else {
            System.out.println("Space already occupied");
        }
        
    }
    
    void initializeBoards(Board[] boards) {
        for (int i = 0; i < boards.length; i++) {
            Board b = new Board(3, 3);
            b.fillWithSpaces();
            boards[i] = b;
        }
    }
    
    void printBoards(Board[] boards) {
        for (Board b: boards) {
            b.printBoard();
        }
    }
}
