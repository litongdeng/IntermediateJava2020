import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson8Thread extends JPanel implements Runnable { //a square panel
    int panelWidth, x, y, squareWidth, obstaclex, obstacley;
    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    int dir = -1; // 0, 1, 2, 3 (If ya don't set it, it becomes 0; thus it'll start by moving UP, which we may or may not want)

    public Lesson8Thread(int w) {
        panelWidth = w;
        squareWidth = 10;
        x = y = panelWidth / 2 - squareWidth / 2;
        obstaclex = (int)(Math.random() * panelWidth);
        obstacley = (int)(Math.random() * panelWidth);

        setPreferredSize(new Dimension(w, w));
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("Key-press detected! " + e.getKeyCode());
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        dir = UP;
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        dir = DOWN;
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        dir = LEFT;
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        dir = RIGHT;
                        break;
                    }
                }
                repaint();
            }
        });
    }

    public void run() {
        int speed = 2;
        while (true) {
            switch (dir) {
                case UP: // note that you don't need curly brackets b/c you have the colon and the break command
                    y -= speed;
                    getGraphics().fillRect(x, y, squareWidth, squareWidth);
                    break;
                case DOWN:
                    y += speed;
                    getGraphics().fillRect(x, y, squareWidth, squareWidth);
                    break;
                case LEFT:
                    x -= speed;
                    getGraphics().fillRect(x, y, squareWidth, squareWidth);
                    break;
                case RIGHT:
                    x += speed;
                    getGraphics().fillRect(x, y, squareWidth, squareWidth);
                    break;
            }
            if (x <= 0 || y <= 0 || x >= panelWidth - squareWidth || y >= panelWidth - squareWidth) {
                x = y = panelWidth / 2 - squareWidth / 2;
            } else if (x >= obstaclex && x <= obstaclex + squareWidth * 2 && y >= obstacley && y <= obstacley + squareWidth * 2) {
                x = y = panelWidth/2 - squareWidth/2;
            }
                repaint();
            try {
                Thread.sleep(20); // every 20 seconds, the run function will execute
            } catch (InterruptedException ie) {
                // System.out.println("I was interrupted!");
            }
        }
    }

    public static void main(String[] argv) {
        JFrame myFrame = new JFrame("My First JFrame");
        //myFrame.setLocation(600, 600);
        Lesson8Thread myPanel = new Lesson8Thread(500);
        myPanel.setBackground(Color.PINK);
        myFrame.setResizable(false);
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
        g.fillRect(x, y, squareWidth, squareWidth);
        g.fillRect(obstaclex, obstacley, squareWidth * 2, squareWidth * 2);
    }
} //end of class