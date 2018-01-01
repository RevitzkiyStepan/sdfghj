package javaSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aronDillQs5328 on 15.04.2017.
 */
public class MyWindow extends JFrame{
    static JTextArea textArea;

    public MyWindow() throws HeadlessException {
        setSize(800, 480);
        setLocation(560,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My window");

        textArea = new JTextArea();
        add(textArea);
        textArea.append("sth");


        JButton jButton = new JButton("кнопка");
        add(jButton, BorderLayout.EAST);

        setVisible(true);
    }
}
