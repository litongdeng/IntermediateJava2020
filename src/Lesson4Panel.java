import javax.swing.*;
import java.awt.*;

public class Lesson4Panel extends JPanel {
    public Lesson4Panel() {
        setPreferredSize(new Dimension(400, 400));
    }

    public static void main(String[] argv) {
        JFrame myFrame = new JFrame("Insert Title Here");
        JPanel myPanel = new Lesson4Panel();
        myPanel.setBackground(Color.PINK);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.black);
//        g.drawLine(300, 20, 500, 100);
//        g.drawLine(0, 0, 500, 300);
//        g.drawLine(500, 0, 0, 300);
//        g.setColor(Color.magenta);
//        g.drawRect(50, 50, 400, 200);
//        g.setColor(Color.blue);
//        g.fillRect(50, 50, 400, 200);
//        g.setColor(Color.yellow);
//        g.drawOval(50, 50, 400, 200);

        // Olympic Rings
//        g.setColor(Color.blue);
//        g.drawOval(15, 15, 69, 69);
//        g.setColor(Color.black);
//        g.drawOval(85, 15, 69, 69);
//        g.setColor(Color.red);
//        g.drawOval(155, 15, 69, 69);
//        g.setColor(Color.yellow);
//        g.drawOval(45, 70, 69, 69);
//        g.setColor(Color.green);
//        g.drawOval(125, 70, 69, 69);

        // drawBoard(g, 3);
        //drawBoard(g, 8);

        drawChessBoard(g);
    }

    // Drawing an NxN Board
    void drawBoard(Graphics g, int n) {
        g.drawRect(100, 0, 300, 300);
        //draw n-1 horizontal lines evenly spaced out
        int eachy = 300 / n;
        for (int i = 1; i <= n - 1; i++) {
            g.drawLine(100, 0 + i * eachy, 400, 0 + i * eachy);
        }
        //draw n-2 vertical lines evenly spaced out
        int eachx = 300 / n;
        for (int i = 1; i <= n - 1; i++) {
            g.drawLine(100 + i * eachy, 0, 100 + i * eachy, 300);
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

