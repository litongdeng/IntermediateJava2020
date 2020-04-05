import java.util.Scanner;

public class Lesson3TicTacToe {
    public static void main(String[] argv) {
        char[][] board = new char[3][3]; //default value for empty slots is "null"
        //initiate all empty spaces to '_'
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = '_';
            }
        }
        char player = 'X';
        Scanner sc = new Scanner(System.in);

        while (true) {
            //print board
            printBoard(board);

            //ask a player to play
            System.out.println(player + ", it is your turn. Enter the row index and the column index. (e.g. 0 2)");
            int row = sc.nextInt(); // which row
            int column = sc.nextInt(); // which column
            if (board[row][column] == '_') {
                board[row][column] = player;
            } else {
                System.out.println("That space is already taken. Please choose an empty space. ");
                continue;
            }

            //check if anyone wins, if yes, break, else continue with the game
            if (checkWin(board)) {
                printBoard(board);
                System.out.println();
                System.out.println(player + ", you won! ");
                break;
            } else if (checkTie(board)) {
                printBoard(board);
                System.out.println();
                System.out.println(player + ", tie game! ");
                break;
            } else {
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
            }

        }

    }

    static boolean checkTie(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoard(char[][] b) {
        for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[0].length; c++) {
                System.out.print(b[r][c] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char[][] b) {
        //check if any row contains the same pieces
        rowChecking: for (int r = 0; r < b.length; r++) {
            for (int c = 1; c < b[0].length; c++) {
                if (b[r][c] == '_' || b[r][c] != b[r][0]) {
                    //bad row, stop checking this row, move on to next row
                    continue rowChecking;
                }
            }
            //if my code ever comes here, that means rowChecking never resumed, which means I found good row
            return true;
        }
        //check if any column contains the same pieces
        columnChecking: for (int c = 0; c < b[0].length; c++) {
            for (int r = 1; r < b.length; r++) {
                if (b[r][c] == '_' || b[r][c] != b[0][c]) {
                    //bad column, stop checking this column, move on to next column
                    continue columnChecking;
                }
            }
            //if my code ever comes here, that means columnChecking never resumed, which means I found good column
            return true;
        }
        //check two diagonals
        //assuming the board has the same # of rows and columns
        boolean goodDiagonal = true;
        for (int r = 1; r < b.length; r++) {
            if (b[r][r] == '_' || b[r][r] != b[0][0]) {
                goodDiagonal = false;
                // bad diagonal
                break;
            }
        }
        if (goodDiagonal) {
            return true;
        }

        // checking other diagonal
        goodDiagonal = true;
       for (int r = 1; r < b.length; r++) {
            if (b[r][b.length - 1 - r] == '_' || b[r][b.length - 1 - r] != b[0][b.length - 1]) {
                goodDiagonal = false;
                // bad diagonal
                break;
            }
        }
       if (goodDiagonal) {
           return true;
       }
        return false;
    }
}
