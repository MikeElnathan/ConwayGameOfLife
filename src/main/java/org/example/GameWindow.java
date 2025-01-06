package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    Timer timer;
    GamePanel panel;

    public GameWindow(){
        panel = new GamePanel();
        setTitle("Conway Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.add(panel);
        pack();
        setLocationRelativeTo(null);
        update();
    }
    void update(){
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.update();
                panel.repaint();
//                System.out.println("Generation: " + frames);
            }
        });
        timer.start();
    }
}
