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
    
    static void playGame(Scanner input) {
        Board[] boards = new Board[3];
        initializeBoards(boards);
        
        int playerTurn = 1;
        boolean gameOver = false;
        while (!gameOver) {
            playTurn(playerTurn, input, boards);
            gameOver = checkWin(boards);
            playerTurn = playerTurn % 2 + 1;
        }
        
        System.out.println("Player " + playerTurn + " wins!");
    }
    
    static void playTurn(int turn, Scanner input, Board[] boards) {
        printBoards(boards);
        System.out.println("Player " + turn + " turn (board, row, col):");
        
        int boardIndex;
        int row;
        int col;
        boolean repeat = false;
        do {
            repeat = false;
            String[] playerInput = input.nextLine().split(",");
            boardIndex = Integer.valueOf(playerInput[0].strip())-1;
            row = Integer.valueOf(playerInput[1].strip())-1;
            col = Integer.valueOf(playerInput[2].strip())-1;
            
            if (boardIndex < 0 || boardIndex >= boards.length) {
                System.out.println("Board " + boardIndex+1 + " is invalid");
                repeat = true;
            } else if (boards[boardIndex].checkWin()) {
                System.out.println("Board " + boardIndex+1 + " is out of play");
            }
            if (row < 0 || row > 2) {
                System.out.println("Play in row 1, 2, or 3");
                repeat = true;
            }
            if (col < 0 || col > 2) {
                System.out.println("Play in col 1, 2, or 3");
                repeat = true;
            }
            if (!repeat && !boards[boardIndex].board[row][col].equals(" ")) {
                System.out.println("Space already occupied");
                repeat = true;
            }
        } while (repeat);
        
        String[][] board = boards[boardIndex].board;
        if (board[row][col].equals(" ")) {
            board[row][col] = "X";
        } else {
            System.out.println("Space already occupied");
        }
        
    }
    
    static boolean checkWin(Board[] boards) {
        for (Board b: boards) {
            if (!b.checkWin()) {
                return false;
            }
        }
        
        return true;
    }
    
    static void initializeBoards(Board[] boards) {
        for (int i = 0; i < boards.length; i++) {
            Board b = new Board(3, 3);
            b.fillWithSpaces();
            boards[i] = b;
        }
    }
    
    static void printBoards(Board[] boards) {
        for (Board b: boards) {
            b.printBoard();
        }
    }
}
