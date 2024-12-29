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

        organism.drawOrganism(g);
        organism.drawGrid(g);
    }
}
