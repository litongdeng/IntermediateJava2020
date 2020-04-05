import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson6GraphicTTT extends JPanel {
    int panelWidth, boardWidth = 300;
    final char EMPTY = '_';
    char[][] board = new char[3][3];
    char piece = 'X';
    boolean gameOver;


    public Lesson6GraphicTTT() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = EMPTY;
            }
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("I detected a mouse event at (" + e.getX() + ", " + e.getY() + ")");
                if (gameOver) {
                    if (e.getY() > boardWidth) { //clicking in the message area to start a new game
                        for (int r = 0; r < board.length; r++) {
                            for (int c = 0; c < board[0].length; c++) {
                                board[r][c] = EMPTY;
                            }
                        }
                        gameOver = false;
                        repaint();
                        return;
                    }
                } else { // when the game is NOT over
                    int gridSqWidth = boardWidth / 3; // number of rows = 3
                    int r = e.getY() / gridSqWidth;
                    int c = e.getX() / gridSqWidth;
                    System.out.println(" ---> r = " + r + ", c = " + c);
                    if (r >= board.length || c >= board[0].length) {
                        return;
                    }
                    if (board[r][c] == EMPTY) {
                        board[r][c] = piece;
                    } else {
                        return;
                    }
                    if (Lesson3TicTacToe.checkWin(board)) {
                        System.out.println(piece + ", you won! Congratulations! ");
                        gameOver = true;
                    } else if (Lesson3TicTacToe.checkTie(board)) {
                        System.out.println("There is a tie! ");
                        gameOver = true;
                    }
                    repaint(); //signal to invoke paintComponent
                    if (piece == 'X') {
                        piece = 'O';
                        setBackground(Color.PINK);
                    } else {
                        piece = 'X';
                        setBackground(Color.BLUE);
                    }
                }
            }
        });
    }

    public static void main(String[] argv) {
        JFrame myFrame = new JFrame("Insert Title Here");
        Lesson6GraphicTTT myPanel = new Lesson6GraphicTTT();
        myPanel.panelWidth = 300;
        myPanel.setPreferredSize(new Dimension(myPanel.panelWidth, 400));
        myPanel.setBackground(Color.PINK);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g, 3);
        drawPieces(g);
        if (Lesson3TicTacToe.checkWin(board)) {
            if (piece == 'X') {
                piece = 'O';
            } else {
                piece = 'X';
            }
            g.drawString(piece + ", you won! Congratulations! ", 100, 350);
        } else if (Lesson3TicTacToe.checkTie(board)){
            g.drawString("There is a tie!", 100, 350);
        }
    }

    public void drawPieces(Graphics g) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == EMPTY) {
                    continue;
                }
                int gridWidth = boardWidth / 3;
                int upperLeft_X = c * gridWidth;
                int upperLeft_Y = r * gridWidth;
                if (board[r][c] == 'X') {
                    // upper-left to bottom-right
                    int bottomRight_X = upperLeft_X + gridWidth;
                    int bottomRight_Y = upperLeft_Y + gridWidth;
                    g.drawLine(upperLeft_X, upperLeft_Y, bottomRight_X, bottomRight_Y);
                    // upper-right to bottom-left
                    g.drawLine(upperLeft_X + gridWidth, upperLeft_Y, bottomRight_X - gridWidth, bottomRight_Y);
                } else { // it must be O
                    g.drawOval(upperLeft_X, upperLeft_Y, gridWidth, gridWidth);
                }
            }
        }
    }

    // Drawing an NxN Board
    void drawBoard(Graphics g, int n) {
        g.drawRect(0, 0, 300, 300);
        //draw n-1 horizontal lines evenly spaced out
        int eachy = 300 / n;
        for (int i = 1; i <= n - 1; i++) {
            g.drawLine(0, 0 + i * eachy, 300, 0 + i * eachy);
        }
        //draw n-2 vertical lines evenly spaced out
        int eachx = 300 / n;
        for (int i = 1; i <= n - 1; i++) {
            g.drawLine(i * eachy, 0, 0 + i * eachy, 300);
        }
    }

    void drawChessBoard(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        double eachTile = 400 / 8d;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRect((int) (eachTile * j), (int) (i * eachTile), (int) (eachTile), (int) (eachTile));
            }
        }
    }
}

