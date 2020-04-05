import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson8 extends JPanel { //a square panel
    int panel_width, x, y, squareWidth;

    public Lesson8(int w) {
        panel_width = w;
        squareWidth = 10;
        x = y = panel_width / 2 - squareWidth / 2;
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
                        y -= 10;
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        y += 10;
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        x -= 10;
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        x += 10;
                        break;
                    }
                }
                repaint();
            }
        });
    }

    public static void main(String[] argv) {
        JFrame myFrame = new JFrame("My First JFrame");
        //myFrame.setLocation(600, 600);
        Lesson8 myPanel = new Lesson8(500);
        myPanel.setBackground(Color.PINK);
        myFrame.setResizable(false);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null); //call this after the pack() call
        myFrame.setVisible(true);
    }

    //invoked by the repaint() call
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(x, y, squareWidth, squareWidth);
    }

} //end of class