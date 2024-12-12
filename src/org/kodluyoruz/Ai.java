package org.kodluyoruz;

import java.util.Random;

public class Ai {


    int[] aiScore;

    public void addValueAI(String mat[][]){

        String value ="os";
        String[] part = value.split("");

        int count=1;

        Random random = new Random();

        int selectValueIndex = random.nextInt((1-0)+1)+0;

        while (count!=0){

            int randomRow = random.nextInt(( (mat[0].length-1)-0)+1)+0;
            int randomColumn = random.nextInt(( (mat[1].length-1)-0)+1)+0;

            if(mat[randomRow][randomColumn] !="-")
                continue;


            mat[randomRow][randomColumn]=part[selectValueIndex];
            count--;
        }

        System.out.println("AI played.");


    }
}
