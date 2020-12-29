package org.kodluyoruz;

import java.util.Random;

public class Player {

    int[] playerScore;

    public void addValuePlayer(String mat[][],int row,int column){

        String value ="os";
        String[] part = value.split("");
        Random random = new Random();
        int selectValueIndex = random.nextInt((1-0)+1)+0;

        mat[row-1][column-1] = part[selectValueIndex];

        System.out.println("Player played.");

    }



}
