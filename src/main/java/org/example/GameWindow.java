package org.example;

import javax.swing.*;

public class GameWindow extends JFrame {


    public GameWindow(){
        setTitle("Conway Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.add(new GamePanel());
        pack();
    }
}
