import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson8Rainbow extends JPanel implements Runnable { //a square panel
    int panelWidth, radius, centerX, centerY, x, y, squareWidth = 16, speed = 10, color = 0;
    double angle;
    Color[] colors = {Color.red, Color.ORANGE, Color.yellow, Color.green, Color.blue, new Color(75,0,130), new Color(143,0,255)};
    public Lesson8Rainbow(int w) {
        panelWidth = w;
        setPreferredSize(new Dimension(w, w));
        centerX = centerY = panelWidth / 2 - 5;
        radius = panelWidth/3;
        angle = 190;
        color = 0;
    }
    public void run() {
        while (true) {
            if (angle == 350) {
                angle = 190;
                color++;
                radius -= squareWidth;
            }
            x = (int) (centerX + radius * Math.cos(Math.toRadians(angle)));
            y = (int) (centerX + radius * Math.sin(Math.toRadians(angle)));
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) { }
            if (color >= colors.length) {
                color = 0;
                radius = panelWidth/3;
                angle = 190;
                repaint();
            } else {
                Color c = colors[color];
                Graphics g = getGraphics();
                g.setColor(c);
                g.fillOval(x, y, squareWidth, squareWidth);
                angle++;
            }
        }
    }

    public static void main(String[] argv) {
        JFrame myFrame = new JFrame("Rainbow!");
        //myFrame.setLocation(600, 600);
        Lesson8Rainbow myPanel = new Lesson8Rainbow(500);
        myPanel.setBackground(new Color(0x84,0xE4,0xF7));
        myFrame.setFocusable(true);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null); //call this after the pack() call
        myFrame.setVisible(true);
        new Thread(myPanel).start(); // forking out a thread; "activating" the run func
        // like a fork in the road - branching out something that will run infinitely
    }

    //invoked by the repaint() call
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.fillRect(x, y, squareWidth, squareWidth);
    }

} //end of class