package org.kodluyoruz;

public class Board {


    String[][] board;

    public  void initalizeBoard(String[][] matrix){

        for(int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                matrix[i][j]="-";
            }
        }

    }

    public  void printBoard(String mat[][])
    {

        System.out.print(" ");
        for (int row = 1; row < mat.length+1; row++) {
            System.out.print("  " + row );
        }
        System.out.println();
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (col < 1) {
                    System.out.print(row+1);
                    System.out.print("  " + mat[row][col]);
                } else {

                    System.out.print("  " + mat[row][col]);
                }
            }
            System.out.println();
        }

    }

    public void displayScores(int[] playerScore,int[] aiScore){


        for(int i:playerScore){
            System.out.println("Player score:"+i);
        }

        for(int i:aiScore){
            System.out.println("Ai score:"+i);
        }
    }

}
