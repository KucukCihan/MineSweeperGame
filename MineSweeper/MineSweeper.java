package MineSweeper;

import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    boolean showMines;
    int mineAmount;
    int[][] area;
    char[][] emptyField;
    char[][] mine;
    int axisRow;
    int axisCol;
    boolean isWin = false;
    boolean fail = false;
    int stepsToEnd;
    int playCount = 0;


    public MineSweeper (int rowNumber, int colNumber, boolean showMines) {    // constructor
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.showMines = showMines;
        this.mineAmount = ( (this.rowNumber * this.colNumber) / 4 );
        this.area = new int[this.rowNumber][this.colNumber];
        this.emptyField = new char[this.rowNumber][this.colNumber];
        this.mine = new char[this.rowNumber][this.colNumber];
        this.stepsToEnd = ( (this.rowNumber * this.colNumber) - this.mineAmount);
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        deployMine(rowNumber, colNumber);
        fillArea();

        if (this.showMines) {
            printArray(mine);
            printArray(area);
        }

        System.out.println("===========================\n" +
                "Welcome to the MineSweeper Game !");
        do {
            printArray(emptyField);

            System.out.print("Insert row coordinate :\t");
            this.axisRow = sc.nextInt();
            System.out.print("Insert column coordinate : ");
            this.axisCol = sc.nextInt();

            // check if inputs are in interval of game area ------------------- below
            if ( (this.axisRow < 0 || this.axisRow >= this.rowNumber)
                    && (this.axisCol < 0 || this.axisCol >= this.colNumber) ) {
                System.out.println("Enter a row value in interval of [0," + (rowNumber-1) + "]" );
                System.out.println("Enter a column value in interval of [0," + (colNumber-1) + "]" );
                continue;
            } else if (this.axisRow < 0 || this.axisRow >= this.rowNumber) {
                System.out.println("Enter a row value in interval of [0," + (rowNumber-1) + "]" );
                continue;
            } else if (this.axisCol < 0 || this.axisCol >= this.colNumber) {
                System.out.println("Enter a column value in interval of [0," + (colNumber-1) + "]" );
                continue;
            }                                           //  ------------------- ends


            changeField(axisRow, axisCol);
            if (fail) {
                System.out.println("You have stepped on a mine, GAME OVER!");
                System.out.println("\n-------- Mine locations --------");
                printArray(mine);                             // show mine areas
                System.out.println("\n----------- Progress -----------");
                printArray(emptyField);                       // show progress
                System.out.println("\nGOOD LUCK NEXT TIME!");
            } else if (isWin) {
                System.out.println("You have never stepped on a mine, CONGRATULATIONS!");

                System.out.println("\n-------- Mine locations --------");
                printArray(mine);
                System.out.println("\nYOU HAVE WON THE GAME!");

            }



        } while (!fail && !isWin);
    }

    void deployMine(int rowNumber, int colNumber) {
        // fill area-emptyField-mine with clear marks
        for (int a = 0; a < rowNumber; a++) {
            for (int b = 0; b < colNumber; b++) {
                this.area[a][b] = 0;         //  "0" means no mine near [a][b] location
                this.emptyField[a][b] = '-'; //  "-" means area is clear
                this.mine[a][b] = '-';
            }
        }

        // insert mine(*) on random spots mineAmount times
        int i = 0;
        while (i < this.mineAmount) {
            if (this.mine[rNG(rowNumber)][rNG(colNumber)] != '*') { // if location is already mined;
                i++;
                this.mine[rNG(rowNumber)][rNG(colNumber)] = '*';  // "*" means location is mined
            }
        }
    }

    int rNG(int range) {   // random number generator in [0-range) interval
        return (int) Math.floor(Math.random() * range);
    }

    void fillArea() {
        for (int x = 0; x < this.rowNumber; x++) {      // go through all possible locations
            for (int y = 0; y < this.colNumber; y++) {

                if (mine[x][y] == '*') {           // if location is mined
                    for (int i = (x - 1); i <= (x + 1); i++) {  // increase locations 1 block surroundings
                        for (int j = (y - 1); j <= (y + 1); j++) {

                            if ( (i >= 0) && (i < this.rowNumber) && (j >= 0) && (j < this.colNumber) ) {
                                area[i][j]++;
                            }
                        }
                    }
                }
            }
        }
    }

    void changeField(int r, int c) {
        if (emptyField[r][c] == '-') {
            this.playCount++;
        }
        String str = "" + area[r][c];
        emptyField[r][c] = str.charAt(0);  // convert "-" to "int"


        if (playCount == stepsToEnd) {
            isWin = true;
        }

        if (mine[r][c] == '*') {   // if inputs are in mine location
            emptyField[r][c] = mine[r][c];
            fail = true;        // end the game by losing
        }
    }



    //   --------- PRINT METHODS ---------
    void printArray(char[][] array) {
        for (char[] chars : array) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    void printArray(int[][] array) {
        for (int[] chars : array) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }


}
