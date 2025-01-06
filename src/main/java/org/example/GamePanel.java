package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    protected int screenHeight = 600;
    protected int screenWidth = 600;
    Organism organism;
    String statusText;
    protected int statusScreenOffset = 24;

    public GamePanel(){
        statusText = "";
        setBackground(Color.black);
        setPreferredSize(new Dimension((screenWidth + 1), (screenHeight + statusScreenOffset)));
        organism = new Organism(this);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        organism.drawOrganism(g);
//        render status text, ie; play, pause, clear
        g.setColor(Color.white);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        g.drawString(statusText, screenWidth/3, screenHeight + 20);
    }
    void drawGrid(Graphics g){
        for(int i = 0; i < screenHeight + 20; i+=organism.cellSize){
            g.setColor(new Color(255,255,255,128));
            g.drawLine(0, i, screenHeight, i);
        }
        for(int j = 0; j < screenWidth + 20; j+=organism.cellSize){
            g.setColor(new Color(255,255,255,128));
            g.drawLine(j, 0, j, screenWidth);
        }
    }
    void update(){
        organism.updateState();
    }
}

