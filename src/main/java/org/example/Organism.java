package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Organism {
    private final GamePanel panel;
    int cellSize = 20;
    int organismSize = 10;
    boolean[][] cellState = new boolean[20][20];
    Random rand;

    public Organism(GamePanel panel){
        this.panel = panel;
        rand = new Random();
    }

    public void drawOrganism(Graphics g){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                if(cellState[i][j]){
                    int x = i*cellSize;
                    int y = j*cellSize;
                    g.setColor(Color.red);
                    g.fillRect((x + 5), (y + 5), organismSize, organismSize);
                }
            }
        }
        System.out.println(Arrays.deepToString(cellState));
    }
    boolean randomCellState(){
       int temp = rand.nextInt(20);
        return temp % 2 == 0;
    }
    void fillArray(){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                cellState[i][j] = randomCellState();
            }
        }
    }
}
