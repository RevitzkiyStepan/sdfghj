package geekbrains.AsteroidGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Stepan on 29.11.2016.
 */
public class GameWindow extends JFrame{

    private static GameWindow gameWindow;
    private static long lastFrameTime;
    private static Image fon;
    private static Image end;
    private static Image logo;

    private static float dropLeft = 100;
    private static float dropTop = -100;
    private static float dropV = 100;
    private static int score = 0;


    public static void main(String[] args) throws IOException{
        fon = ImageIO.read(GameWindow.class.getResourceAsStream("fon.jpg"));
        end = ImageIO.read(GameWindow.class.getResourceAsStream("end.png"));
        logo = ImageIO.read(GameWindow.class.getResourceAsStream("logo.png"));
        gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(200, 100);
        gameWindow.setSize(906, 478);
        gameWindow.setResizable(false);
        lastFrameTime = System.nanoTime();
        GameField gameField = new GameField();
        gameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float dropRight = dropLeft + logo.getWidth(null);
                float dropBottom = dropTop + logo.getHeight(null);
                boolean isDrop = x >= dropLeft && x <= dropRight && y >= dropTop && y <= dropBottom;
                if(isDrop){
                    dropTop = -100;
                    dropLeft = (int)(Math.random() * (gameField.getWidth() - logo.getWidth(null)));
                    dropV = dropV + 20;
                    score++;
                    gameWindow.setTitle("score: " + score);
                }
            }
        });
        gameWindow.add(gameField);
        gameWindow.setVisible(true);

    }

    private static void onRepaint(Graphics g){
        //g.fillOval(10, 10, 200, 100);
        //g.drawRect(300, 200, 100, 100);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        dropTop = dropTop + dropV * deltaTime;
        g.drawImage(fon, 0, 0, null);
        g.drawImage(logo, (int)dropLeft, (int)dropTop, null);
        if(dropTop > gameWindow.getHeight())
            g.drawImage(end, 280, 120, null);

    }

    private static class GameField extends JPanel{

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
