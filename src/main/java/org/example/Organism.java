package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Organism {
    private final GamePanel panel;
    int cellSize ;
    int organismSize;
    int cellOffset;
    int[][] cellState;
    int[][] holdState;
    Random rand;

    public Organism(GamePanel panel){
        this.panel = panel;
        cellSize = panel.screenHeight/20;
        organismSize = cellSize/2;
        cellOffset = cellSize/4;
        cellState = new int[cellSize][cellSize];
        holdState = new int[cellSize][cellSize];
        rand = new Random();
        fillArray(cellState);
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
    int howToFillArray(){
       int temp = rand.nextInt(20);
        return temp % 2 == 0? 1:0;
    }
    void fillArray(int[][] cellState){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                cellState[i][j] = howToFillArray();
            }
        }
    }
    int returnSum(int x, int y, int[][] cellState){
        int sum = 0;

        for(int i = (x - 1); i <= (x + 1); i++){
            for(int j = (y - 1); j <= (y + 1); j++){
                if(i >= 0 && i < cellState.length &&  j >= 0 && j < cellState.length){
                    sum += cellState[i][j];
                }
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
        cellState = holdState;
    }
    void updateState(){
        applyRules();
    }
}
