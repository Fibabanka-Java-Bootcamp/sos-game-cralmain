package org.kodluyoruz;

public class SosController {

    public void diagonalController(String matrix[][],int sosIndex[][],int[] counter,int[] score) {

        for(int i=0;i< matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){


                if(i!=0 && i!= matrix.length-1){

                    if(j!=0 && j!=matrix.length-1){


                        if("o".equals(matrix[i][j])){


                            if(("s".equals(matrix[i + 1][j - 1]) && "s".equals(matrix[i - 1][j + 1]))){


                                if(counter[0]==0){

                                    sosIndex[counter[0]][0]=i;
                                    sosIndex[counter[0]][1]=j;

                                    sosIndex[counter[0]][2]=i+1;
                                    sosIndex[counter[0]][3]=j-1;

                                    sosIndex[counter[0]][4]=i-1;
                                    sosIndex[counter[0]][5]=j+1;

                                    counter[0]++;
                                    score[0]++;
                                    System.out.println("Diagonal score");

                                }


                                else {


                                    int sayi = counter[0];
                                    int staticValue = counter[0];
                                    int number = 0;


                                    sosIndex[counter[0]][0] = i;
                                    sosIndex[counter[0]][1] = j;

                                    sosIndex[counter[0]][2] = i + 1;
                                    sosIndex[counter[0]][3] = j - 1;

                                    sosIndex[counter[0]][4] = i - 1;
                                    sosIndex[counter[0]][5] = j + 1;

                                    counter[0]++;

                                    while (sayi != 0) {

                                        if (sosIndexIsEqual(sosIndex, staticValue, sayi)) {

                                            number++;

                                        }
                                        sayi--;
                                    }

                                    if (number == 0){
                                        score[0]++;
                                        System.out.println("Diagonal score");
                                    }

                                }


                            }
                            else if(("s".equals(matrix[i -1][j - 1]) && "s".equals(matrix[i + 1][j + 1]))){


                                if(counter[0]==0){

                                    sosIndex[counter[0]][0]=i;
                                    sosIndex[counter[0]][1]=j;

                                    sosIndex[counter[0]][2]=i-1;
                                    sosIndex[counter[0]][3]=j-1;

                                    sosIndex[counter[0]][4]=i+1;
                                    sosIndex[counter[0]][5]=j+1;

                                    counter[0]++;
                                    score[0]++;
                                    System.out.println("Diagonal score");

                                }


                                else{

                                    int sayi = counter[0];
                                    int staticValue = counter[0];
                                    int number = 0;


                                    sosIndex[counter[0]][0] = i;
                                    sosIndex[counter[0]][1] = j;

                                    sosIndex[counter[0]][2] = i - 1;
                                    sosIndex[counter[0]][3] = j - 1;

                                    sosIndex[counter[0]][4] = i + 1;
                                    sosIndex[counter[0]][5] = j + 1;

                                    counter[0]++;

                                    while (sayi != 0) {

                                        if (sosIndexIsEqual(sosIndex, staticValue, sayi)) {

                                            number++;

                                        }
                                        sayi--;
                                    }

                                    if (number == 0){
                                        score[0]++;
                                        System.out.println("Diagonal score");
                                    }

                                }
                            }
                        }

                    } }
            }
        }


    }

    public void horizontalController(String matrix[][],int sosIndex[][],int[] counter,int[] score){

        for (int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                if("o".equals(matrix[i][j])){

                    if(j>0 && j<matrix[0].length-1){

                        if(("s".equals(matrix[i][j-1]) && "s".equals(matrix[i][j+1]))){

                            if(counter[0]==0){
                                sosIndex[counter[0]][0]=i;
                                sosIndex[counter[0]][1]=j;

                                sosIndex[counter[0]][2]=i;
                                sosIndex[counter[0]][3]=j-1;

                                sosIndex[counter[0]][4]=i;
                                sosIndex[counter[0]][5]=j+1;

                                counter[0]++;
                                score[0]++;
                                System.out.println("Horizontal score");
                            }
                            else{

                                int sayi=counter[0];
                                int staticValue=counter[0];
                                int number=0;

                                sosIndex[counter[0]][0]=i;
                                sosIndex[counter[0]][1]=j;

                                sosIndex[counter[0]][2]=i;
                                sosIndex[counter[0]][3]=j-1;

                                sosIndex[counter[0]][4]=i;
                                sosIndex[counter[0]][5]=j+1;

                                counter[0]++;


                                while (sayi!=0){

                                    if(   sosIndexIsEqual(sosIndex,staticValue,sayi))
                                        number++;

                                    sayi--;
                                }

                                if(number==0){
                                    score[0]++;
                                    System.out.println("Horizontal score");
                                }
                            }
                        } } } } } }



    public static boolean sosIndexIsEqual(int[][] sosIndex,int number,int value){



        if(    ( sosIndex[number][0]==sosIndex[value-1][0]&&
                sosIndex[number][1]==sosIndex[value-1][1]&&
                sosIndex[number][2]==sosIndex[value-1][2]&&
                sosIndex[number][3]==sosIndex[value-1][3]&&
                sosIndex[number][4]==sosIndex[value-1][4]&&
                sosIndex[number][5]==sosIndex[value-1][5])){

            return true;

        }
        return false;

    }
    public void verticalController(String matrix[][],int sosIndex[][],int[] counter,int[] score){

        for (int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){

                if("o".equals(matrix[i][j])){

                    if(i!=0 && i!=matrix.length-1){

                        if(("s".equals(matrix[i-1][j]) && "s".equals(matrix[i +1][j]))){

                            if(counter[0]==0){
                                sosIndex[counter[0]][0]=i;
                                sosIndex[counter[0]][1]=j;

                                sosIndex[counter[0]][2]=i-1;
                                sosIndex[counter[0]][3]=j;

                                sosIndex[counter[0]][4]=i+1;
                                sosIndex[counter[0]][5]=j;

                                counter[0]++;
                                score[0]++;
                                System.out.println("Vertical score");
                            }
                            else{

                                int sayi=counter[0];
                                int staticValue=counter[0];
                                int number=0;



                                sosIndex[counter[0]][0]=i;
                                sosIndex[counter[0]][1]=j;

                                sosIndex[counter[0]][2]=i-1;
                                sosIndex[counter[0]][3]=j;

                                sosIndex[counter[0]][4]=i+1;
                                sosIndex[counter[0]][5]=j;

                                counter[0]++;


                                while (sayi!=0){

                                    if(sosIndexIsEqual(sosIndex,staticValue,sayi)){

                                        number++;

                                    }
                                    sayi--;
                                }
                                if(number==0){
                                    score[0]++;
                                    System.out.println("Vertical score");
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
