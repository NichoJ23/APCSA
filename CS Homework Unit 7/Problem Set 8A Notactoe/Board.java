/**
 * AP Compsci 2024-2025
 * Nicholas Nesbitt
 * 
 */
public class Board {
    String[][] board;
    int numRows;
    int numCols;
    
    Board(int _rows, int _cols) {
        numRows = _rows;
        numCols = _cols;
        board = new String[numRows][numCols];
        
        printBoard();
    }
    
    public boolean checkWin() {
        for (int row = 0; row < board.length; row++) {
            boolean hasSpace = false;
            for (int i = 0; i < board[row].length; i++) {
                if (board[row][i].equals(" ")) hasSpace = true;
            }
            
            if (!hasSpace) return true;
        }
        
        for (int col = 0; col < board.length; col++) {
            boolean hasSpace = false;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col].equals(" ")) hasSpace = true;
            }
            
            if (!hasSpace) return true;
        }
        
        if (board.length == board[0].length) {
            boolean leftRightSpace = false;
            boolean rightLeftSpace = false;
            for (int i = 0; i < board.length; i++) {
                leftRightSpace = leftRightSpace || board[i][i].equals(" ");
                rightLeftSpace = rightLeftSpace || board[i][board[0].length-i-1].equals(" ");
            }
            
            if (!leftRightSpace || !rightLeftSpace) {
                return true;
            }
        }
        
        return false;
    }
    
    public void fillWithSpaces() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = " ";
            }
        }
    }
    
    public void printBoard() {
        System.out.println("＿＿＿＿＿");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("[" + board[row][col] + "]");
            }
            System.out.println("");
        }
        System.out.println("‾‾‾‾‾‾‾‾‾");
    }
}
