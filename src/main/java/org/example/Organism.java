package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Organism {
    private final GamePanel panel;
    int cellSize = 20;
    int organismSize = 10;
    int[][] cellState = new int[20][20];
    int[][] holdState = new int[20][20];
    Random rand;

    public Organism(GamePanel panel){
        this.panel = panel;
        rand = new Random();
        randomArray(cellState);
    }

    public void drawOrganism(Graphics g){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                if(cellState[i][j] == 1){
                    int x = i*cellSize;
                    int y = j*cellSize;
                    g.setColor(Color.red);
                    g.fillRect((x + 5), (y + 5), organismSize, organismSize);
                }
            }
        }
    }
    int randomCellState(){
       int temp = rand.nextInt(20);
        return temp % 2 == 0? 1:0;
    }
    void randomArray(int[][] cellState){
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                cellState[i][j] = randomCellState();
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
    void updateState(){
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

}
