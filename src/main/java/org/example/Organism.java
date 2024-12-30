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
    Random rand;

    public Organism(GamePanel panel){
        this.panel = panel;
        rand = new Random();
    }

    public void drawOrganism(Graphics g){
        randomArray(cellState);
        for(int i = 0; i < cellState.length; i++){
            for(int j = 0; j < cellState.length; j++){
                rulesApplied(cellState, i, j);
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
    int[][] rulesApplied(int[][] cellState, int x, int y){
        int temp = returnSum(x, y, cellState);
//        any live cell with fewer than two live neighbors, dies.
//        any live cell with two or three live neighbors lives on to the next generation.
//        any live cell with more than three live neighbors, dies.
            if(cellState[x][y] == 1){
                cellState[x][y] = (temp == 2 || temp ==3)? 1:0;
            }
//        any dead cell with exactly three live neighbor, will become a live cell
            else if(cellState[x][y] == 0){
                cellState[x][y] = (temp == 3)? 1:0;
            }
        return cellState;
    }

}
