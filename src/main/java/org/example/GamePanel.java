package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    protected int screenHeight = 400;
    protected int screenWidth = 400;
    Organism organism;

    public GamePanel(){
        setBackground(Color.black);
        setPreferredSize(new Dimension((screenWidth + 1), (screenHeight + 1)));
        organism = new Organism(this);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < screenHeight + 20; i+=organism.cellSize){
            g.setColor(Color.white);
            g.drawLine(0, i, screenHeight, i);
        }
        for(int j = 0; j < screenWidth + 20; j+=organism.cellSize){
            g.setColor(Color.white);
            g.drawLine(j, 0, j, screenWidth);
        }
    }
    void update(){

    }
}
