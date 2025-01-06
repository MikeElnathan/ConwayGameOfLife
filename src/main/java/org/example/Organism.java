package org.example;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Organism {
    private final GamePanel panel;
    int cellSize ;
    int organismSize;
    int cellOffset;
    int[][] cellState;
    int[][] holdState;
    Random rand;
    boolean playSimulation = false;

    public Organism(GamePanel panel){
        this.panel = panel;
        cellSize = 20;
        organismSize = cellSize/2;
        cellOffset = cellSize/4;
        cellState = new int[panel.screenWidth/cellSize][panel.screenHeight/cellSize];
        holdState = new int[panel.screenWidth/cellSize][panel.screenHeight/cellSize];
        rand = new Random();
//        fillArray(cellState);
        panel.setFocusable(true);
        playPause();
        drawArray();
    }
    public void drawOrganism(Graphics g){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                if(cellState[i][j] == 1){
                    int x = i*cellSize;
                    int y = j*cellSize;
                    g.setColor(Color.red);
                    g.fillRect((x + cellOffset), (y + cellOffset), organismSize, organismSize);
                }
            }
        }
    }
    void playPause(){
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    playSimulation = !playSimulation;
                    if(playSimulation){
                        panel.statusText = "Simulation started";
                    }else panel.statusText = "Simulation paused";
                }
                if(e.getKeyCode() == KeyEvent.VK_C){
                    for (int i = 0; i < cellState.length; i++){
                        for (int j = 0; j < cellState.length; j++){
                            cellState[i][j] = 0;
                            panel.statusText = "Screen cleared";
                        }
                    }
                }
            }
        });
    }
    void drawArray(){
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!playSimulation){
                    cellState[e.getX()/cellSize][e.getY()/cellSize] = 1;
                }
            }
        });
    }
    int returnSum(int x, int y, int[][] cellState){
        int sum = 0;

        for(int i = (x - 1); i <= (x + 1); i++){
            for(int j = (y - 1); j <= (y + 1); j++){
                int wrappedX = (i + cellState.length)%cellState.length;
                int wrappedY = (j + cellState.length)%cellState.length;
                sum += cellState[wrappedX][wrappedY];
            }
        }
        sum -= cellState[x][y];
        return sum;
    }
    void applyRules(){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                int temp = returnSum(i, j, cellState);
                if(cellState[i][j] == 1){
                    holdState[i][j] = (temp == 2 || temp ==3)? 1:0;
                }
                else if(cellState[i][j] == 0){
                    holdState[i][j] = (temp == 3)? 1:0;
                }
            }
        }
        for(int i = 0; i < cellState.length; i++){
            System.arraycopy(holdState[i], 0, cellState[i], 0, cellState.length);
        }
    }
    void updateState(){
        if(playSimulation){
            applyRules();
            System.out.println(playSimulation);
        }
    }
}
