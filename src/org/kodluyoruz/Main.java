package org.kodluyoruz;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        SosController sosController = new SosController();


        Player player = new Player();
        Board board = new Board();
        Ai ai = new Ai();

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

        String[][] gameBoard =new String[size][size];

        int[] playerScore = new int[1];
        int[] aiScore =new int[1];

        int[] diagonalCounter= new int[1];
        int[] horizontalCounter= new int[1];
        int[] verticalCounter = new int[1];


        int[][] verticalIndex=new int[300][6];
        int[][] horizontalIndex=new int[300][6];
        int[][] diagonalIndex=new int[300][6];


        board.initalizeBoard(gameBoard);

        boolean game=true;

        int moveCounter=0;

        int queue =random.nextInt((1-0)+1)+0;

        while (game) {

            if (queue == 0) {

                int indexCount = 1;

                while (indexCount != 0) {



                    System.out.print("Please enter your row which you want to add:");
                    int row = scanner.nextInt();
                    System.out.print("Please enter your column which you want to add:");
                    int column = scanner.nextInt();

                    if (row >= size+1 || column >= size+1) {

                        System.out.println("Out of index.Please check your indexes.");
                        continue;
                    }
                    if (row==0 ||column==0){
                        System.out.println("Row and column number must be bigger than 0");
                        continue;
                    }
                    if (gameBoard[row-1][column-1] != "-") {
                        System.out.println("This spot is occupied. Please try again");
                        continue;

                    }




                    player.addValuePlayer(gameBoard, row, column);
                    indexCount--;
                }


                sosController.diagonalController(gameBoard, diagonalIndex, diagonalCounter, playerScore);
                sosController.horizontalController(gameBoard, horizontalIndex, horizontalCounter, playerScore);
                sosController.verticalController(gameBoard, verticalIndex, verticalCounter, playerScore);

                board.printBoard(gameBoard);
                board.displayScores(playerScore, aiScore);




                if (moveCounter != size * size-1) {

                    ai.addValueAI(gameBoard);

                    sosController.diagonalController(gameBoard, diagonalIndex, diagonalCounter,aiScore);
                    sosController.horizontalController(gameBoard, horizontalIndex, horizontalCounter, aiScore);
                    sosController.verticalController(gameBoard, verticalIndex, verticalCounter, aiScore);


                    board.printBoard(gameBoard);
                    board.displayScores(playerScore, aiScore);

                    moveCounter++;

                }


                if (moveCounter == size * size) {

                    game = false;
                }

                moveCounter++;

                if (moveCounter == size * size) {
                    if(playerScore[0]>aiScore[0]){
                        System.out.println("Player has won the game");
                    }

                    else if(playerScore[0]<aiScore[0]){
                        System.out.println("Ai has won the game");
                    }
                    else if(playerScore[0]==aiScore[0]){
                        System.out.println("Game is draw");
                    }
                    game = false;
                }

            }

            else if(queue==1) {


                if (moveCounter!=size*size) {


                    ai.addValueAI(gameBoard);

                    sosController.diagonalController(gameBoard, diagonalIndex, diagonalCounter, aiScore);
                    sosController.horizontalController(gameBoard, horizontalIndex, horizontalCounter, aiScore);
                    sosController.verticalController(gameBoard, verticalIndex, verticalCounter, aiScore);

                    board.printBoard(gameBoard);
                    board.displayScores(playerScore, aiScore);
                    moveCounter++;
                }

                if(moveCounter!=size*size){

                    int indexCount=1;

                    while (indexCount!=0){

                        System.out.print("Please enter your row which you want to add:");
                        int row = scanner.nextInt();
                        System.out.print("Please enter your column which you want to add:");
                        int column = scanner.nextInt();

                        if (row >= size+1 || column >= size+1) {

                            System.out.println("Out of index.Please check your indexes.");
                            continue;
                        }
                        if (row==0 ||column==0){
                            System.out.println("Row and column number must be bigger than 0");
                            continue;
                        }

                        if (gameBoard[row-1][column-1] != "-") {
                            System.out.println("This spot is occupied. Please try again");
                            continue;
                        }
                        player.addValuePlayer(gameBoard,row,column);
                        indexCount--;
                    }

                    sosController.diagonalController(gameBoard, diagonalIndex, diagonalCounter, playerScore);
                    sosController.horizontalController(gameBoard, horizontalIndex, horizontalCounter, playerScore);
                    sosController.verticalController(gameBoard, verticalIndex, verticalCounter, playerScore);

                    board.printBoard(gameBoard);
                    board.displayScores(playerScore, aiScore);

                    moveCounter++;
                }

                if(moveCounter==size*size){
                    if(playerScore[0]>aiScore[0]){
                        System.out.println("Player has won the game");
                    }

                    else if(playerScore[0]<aiScore[0]){
                        System.out.println("Ai has won the game");
                    }
                    else if(playerScore[0]==aiScore[0]){
                        System.out.println("Game is draw");
                    }
                    game=false;

                }

            }
        }

    }
}

