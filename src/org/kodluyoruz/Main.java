package org.kodluyoruz;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        boolean game=true;
        Random random = new Random();
        Scanner scanner=new Scanner(System.in);
        int size=0;


        int control=1;

        while (control!=0){

            System.out.print("Enter size:");
            size =scanner.nextInt();

            if(!(size>=3 && size<=7)){

                System.out.println("Index must be beetween 3 and 7");
                continue;
            }
            control--;
        }



        String matris[][] = new String[size][size];

        int diagonalValues[][][] =new int[400][2][3];
        int verticalValues[][][] =new int[200][2][3];
        int horizontalValues[][][] =new int[200][2][3];

        int[] playerScore= new int[1];
        int[] aiScore= new int[1];

        int[] diagonalCounter= new int[1];
        int[] verticalCounter= new int[1];
        int[] horizontalCounter= new int[1];


        playerScore[0]=0;
        aiScore[0]=0;

        diagonalCounter[0]=0;
        verticalCounter[0]=0;
        horizontalCounter[0]=0;

        int moveCounter=0;

        initalizeMatrix(matris);

        int whoStarts =random.nextInt((1-0)+1)+0;

        while (game){

            if(whoStarts==0){

                System.out.println("Player starting the game.");


                if (moveCounter!=size*size) {

                    int indexCount=1;

                    while (indexCount!=0){

                        System.out.print("Please enter your row which you want to add:");
                        int row = scanner.nextInt();
                        System.out.print("Please enter your column which you want to add:");
                        int column = scanner.nextInt();

                        if (row >= size || column >= size) {

                            System.out.println("Out of index.Please check your indexes.");
                            continue;
                        }

                        if (matris[row][column] != "-") {
                            System.out.println("This spot is occupied. Please try again");
                            continue;
                        }
                        addValue(matris, row, column);
                        indexCount--;
                    }


                        verticalController(matris, verticalValues, verticalCounter, playerScore);
                        horizontalController(matris, horizontalValues, horizontalCounter, playerScore);
                        diagonalController(matris, diagonalValues, playerScore, diagonalCounter);


                        displayScores(playerScore, aiScore);

                        moveCounter++;

                }

                if(moveCounter!=size*size){

                    addValueAI(matris);
                    verticalController(matris,verticalValues,verticalCounter,aiScore);
                    horizontalController(matris,horizontalValues,horizontalCounter,aiScore);
                    diagonalController(matris,diagonalValues,aiScore,diagonalCounter);

                    displayScores(playerScore,aiScore);
                    moveCounter++;

                }
              if(moveCounter==size*size){

                  game=false;
              }


            }

            else if(whoStarts==1){

                System.out.println("Ai starting the game");

                if (moveCounter!=size*size) {


                    addValueAI(matris);
                    verticalController(matris, verticalValues, verticalCounter, aiScore);
                    horizontalController(matris, horizontalValues, horizontalCounter, aiScore);
                    diagonalController(matris, diagonalValues, aiScore, diagonalCounter);

                    displayScores(playerScore, aiScore);
                    moveCounter++;
                }

                if(moveCounter!=size*size){

                    int indexCount=1;

                    while (indexCount!=0){

                        System.out.print("Please enter your row which you want to add:");
                        int row = scanner.nextInt();
                        System.out.print("Please enter your column which you want to add:");
                        int column = scanner.nextInt();

                        if (row >= size || column >= size) {

                            System.out.println("Out of index.Please check your indexes.");
                            continue;
                        }

                        if (matris[row][column] != "-") {
                            System.out.println("This spot is occupied. Please try again");
                            continue;
                        }
                        addValue(matris, row, column);
                        indexCount--;
                    }
                    verticalController(matris,verticalValues,verticalCounter,playerScore);
                    horizontalController(matris,horizontalValues,horizontalCounter,playerScore);
                    diagonalController(matris,diagonalValues,playerScore,diagonalCounter);

                    displayScores(playerScore,aiScore);
                    moveCounter++;


                }

                if(moveCounter==size*size){
                    game=false;
                }

                }

            }

    }

    public static void initalizeMatrix(String[][] matrix){

        for(int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                matrix[i][j]="-";
            }
        }

    }



    public static void printMatris(String mat[][])
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
    public static void displayScores(int[] playerScore,int[] aiScore){

        for(int i:playerScore){
            System.out.println("Player score:"+i);
        }

        for(int i:aiScore){
            System.out.println("Ai score:"+i);
        }

    }

    public static void addValue(String mat[][],int row,int column){

        String value ="os";
        String[] part = value.split("");
        Random random = new Random();
        int selectValueIndex = random.nextInt((1-0)+1)+0;

        mat[row][column] = part[selectValueIndex];

        System.out.println("Player played.");
        printMatris(mat);

    }
    public static void addValueAI(String mat[][]){

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
        printMatris(mat);

    }

    public static void verticalController(String matrix[][],int sosIndex[][][],int[] counter,int[] score){

        for (int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                if("o".equals(matrix[i][j])){

                    if(i!=0 && i!=matrix.length-1){

                        if(("s".equals(matrix[i-1][j]) && "s".equals(matrix[i +1][j]))){

                            if(counter[0]==0){
                                sosIndex[counter[0]][0][0]=i;
                                sosIndex[counter[0]][0][1]=j;

                                sosIndex[counter[0]][0][2]=i-1;
                                sosIndex[counter[0]][1][0]=j;

                                sosIndex[counter[0]][1][1]=i+1;
                                sosIndex[counter[0]][1][2]=j;

                                counter[0]++;
                                score[0]++;
                            }
                            else{

                                int sayi=counter[0];
                                int staticValue=counter[0];
                                int number=0;



                                sosIndex[counter[0]][0][0]=i;
                                sosIndex[counter[0]][0][1]=j;

                                sosIndex[counter[0]][0][2]=i-1;
                                sosIndex[counter[0]][1][0]=j;

                                sosIndex[counter[0]][1][1]=i+1;
                                sosIndex[counter[0]][1][2]=j;

                                counter[0]++;


                                while (sayi!=0){

                                    if(    ( sosIndex[staticValue][0][0]==sosIndex[sayi-1][0][0]&&
                                            sosIndex[staticValue][0][1]==sosIndex[sayi-1][0][1]&&
                                            sosIndex[staticValue][0][2]==sosIndex[sayi-1][0][2]&&
                                            sosIndex[staticValue][1][0]==sosIndex[sayi-1][1][0]&&
                                            sosIndex[staticValue][1][1]==sosIndex[sayi-1][1][1]&&
                                            sosIndex[staticValue][1][2]==sosIndex[sayi-1][1][2])){

                                        number++;

                                    }
                                    sayi--;
                                }
                                if(number==0){
                                    score[0]++;
                                }
                            }



                        }

                    }

                }


            }
        }


    }
    public static void horizontalController(String matrix[][],int sosIndex[][][],int[] counter,int[] score){

        for (int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                if("o".equals(matrix[i][j])){

                    if(j>0 && j<matrix[0].length-1){

                        if(("s".equals(matrix[i][j-1]) && "s".equals(matrix[i][j+1]))){

                            if(counter[0]==0){
                                sosIndex[counter[0]][0][0]=i;
                                sosIndex[counter[0]][0][1]=j;

                                sosIndex[counter[0]][0][2]=i;
                                sosIndex[counter[0]][1][0]=j-1;

                                sosIndex[counter[0]][1][1]=i;
                                sosIndex[counter[0]][1][2]=j+1;


                                counter[0]++;
                                score[0]++;
                            }
                            else{

                                int sayi=counter[0];
                                int staticValue=counter[0];
                                int number=0;


                                sosIndex[counter[0]][0][0]=i;
                                sosIndex[counter[0]][0][1]=j;

                                sosIndex[counter[0]][0][2]=i;
                                sosIndex[counter[0]][1][0]=j-1;

                                sosIndex[counter[0]][1][1]=i;
                                sosIndex[counter[0]][1][2]=j+1;

                                counter[0]++;


                                while (sayi!=0){

                                    if(    ( sosIndex[staticValue][0][0]==sosIndex[sayi-1][0][0]&&
                                            sosIndex[staticValue][0][1]==sosIndex[sayi-1][0][1]&&
                                            sosIndex[staticValue][0][2]==sosIndex[sayi-1][0][2]&&
                                            sosIndex[staticValue][1][0]==sosIndex[sayi-1][1][0]&&
                                            sosIndex[staticValue][1][1]==sosIndex[sayi-1][1][1]&&
                                            sosIndex[staticValue][1][2]==sosIndex[sayi-1][1][2])){

                                        number++;


                                    }

                                    sayi--;
                                }
                                if(number==0){
                                    score[0]++;
                                }
                            }
                        }

                    }

                }


            }
        }
    }

    private static void diagonalController(String matrix[][],int sosIndex[][][],int[] score,int[] counter) {

        for(int i=0;i< matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){


                if(i!=0 && i!= matrix.length-1){

                    if(j!=0 && j!=matrix.length-1){


                        if("o".equals(matrix[i][j])){


                            if(("s".equals(matrix[i + 1][j - 1]) && "s".equals(matrix[i - 1][j + 1]))){

                                if(counter[0]==0){

                                    sosIndex[counter[0]][0][0]=i;
                                    sosIndex[counter[0]][0][1]=j;

                                    sosIndex[counter[0]][0][2]=i+1;
                                    sosIndex[counter[0]][1][0]=j-1;

                                    sosIndex[counter[0]][1][1]=i-1;
                                    sosIndex[counter[0]][1][2]=j+1;

                                    counter[0]++;
                                    score[0]++;



                                }

                                else{

                                    int sayi=counter[0];
                                    int staticValue=counter[0];
                                    int number=0;

                                    sosIndex[counter[0]][0][0]=i;
                                    sosIndex[counter[0]][0][1]=j;

                                    sosIndex[counter[0]][0][2]=i+1;
                                    sosIndex[counter[0]][1][0]=j-1;

                                    sosIndex[counter[0]][1][1]=i-1;
                                    sosIndex[counter[0]][1][2]=j+1;

                                    counter[0]++;

                                    while (sayi!=0){

                                        if(    ( sosIndex[staticValue][0][0]==sosIndex[sayi-1][0][0]&&
                                                sosIndex[staticValue][0][1]==sosIndex[sayi-1][0][1]&&
                                                sosIndex[staticValue][0][2]==sosIndex[sayi-1][0][2]&&
                                                sosIndex[staticValue][1][0]==sosIndex[sayi-1][1][0]&&
                                                sosIndex[staticValue][1][1]==sosIndex[sayi-1][1][1]&&
                                                sosIndex[staticValue][1][2]==sosIndex[sayi-1][1][2])){

                                            number++;


                                        }



                                        sayi--;
                                    }

                                    if(number==0)
                                        score[0]++;

                                }

                            }
                            else if(("s".equals(matrix[i -1][j - 1]) && "s".equals(matrix[i + 1][j + 1]))){

                                if(counter[0]==0){

                                    sosIndex[counter[0]][0][0]=i;
                                    sosIndex[counter[0]][0][1]=j;

                                    sosIndex[counter[0]][0][2]=i-1;
                                    sosIndex[counter[0]][1][0]=j-1;

                                    sosIndex[counter[0]][1][1]=i+1;
                                    sosIndex[counter[0]][1][2]=j+1;

                                    counter[0]++;
                                    score[0]++;



                                }

                                else{

                                    int sayi=counter[0];
                                    int staticValue=counter[0];
                                    int number=0;

                                    sosIndex[counter[0]][0][0]=i;
                                    sosIndex[counter[0]][0][1]=j;

                                    sosIndex[counter[0]][0][2]=i-1;
                                    sosIndex[counter[0]][1][0]=j-1;

                                    sosIndex[counter[0]][1][1]=i+1;
                                    sosIndex[counter[0]][1][2]=j+1;

                                    counter[0]++;

                                    while (sayi!=0){

                                        if(    ( sosIndex[staticValue][0][0]==sosIndex[sayi-1][0][0]&&
                                                sosIndex[staticValue][0][1]==sosIndex[sayi-1][0][1]&&
                                                sosIndex[staticValue][0][2]==sosIndex[sayi-1][0][2]&&
                                                sosIndex[staticValue][1][0]==sosIndex[sayi-1][1][0]&&
                                                sosIndex[staticValue][1][1]==sosIndex[sayi-1][1][1]&&
                                                sosIndex[staticValue][1][2]==sosIndex[sayi-1][1][2])){

                                            number++;


                                        }



                                        sayi--;
                                    }

                                    if(number==0)
                                        score[0]++;

                                }
                            }
                        }
                    } }
            }
        }


    }


}
