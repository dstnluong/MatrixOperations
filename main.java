//Dustin Luong and Benjamin Lee

import java.util.*;
public class main {
    public static void main(String [] arg) {
        while(true) {
            Scanner in = new Scanner(System.in); // prompt user for choice of operation
            System.out.println("What matrix operation would you like to perform?");
            System.out.println("1) Scalar Multiplication");
            System.out.println("2) Determinant of a 2x2 or 3x3");
            System.out.println("3) Matrix Addition");
            System.out.println("4) Matrix Subtraction");
            System.out.println("5) Matrix Multiplication");
            System.out.println("6) Scalar Multiplication");
            System.out.println("7) Reduced-Row Echelon Form");
            int userInput = in.nextInt(); // depending on input, move to relevant part of code
            if(userInput == 2) { //Determinant
                in = new Scanner(System.in);
                System.out.println("Press 2 for a 2x2 matrix. Press 3 for a 3x3 matrix");
                int choice = in.nextInt();
                int[][] matrix = new int[choice][choice];//build new matrix size depending on input
                for(int i = 0; i < choice; i++) { //input values for matrix
                    System.out.println(choice + "x" + choice + ":" + " Enter " + choice + " values for row " + (i + 1));
                    for(int j = 0 ; j < choice; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }
                if(choice == 2) {//method for finding determinant for 2x2
                    System.out.println("The determinant is: " + (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]));
                    
                }
                if(choice == 3){
                    int firstSums = 0;
                    int secondSums = 0;
                    for(int k = 0; k < choice; k++) {//shifts the diagonal
                        int diagonal1 = 1;
                        int diagonal2 = 1;
                        for(int i = 0; i < choice; i++) {//takes values along diagonal and sums them
                            diagonal1 *= matrix[i][(i + k) % choice];
                            diagonal2 *= matrix[choice - i - 1][(i + k)  % choice];
                        }
                        firstSums += diagonal1;
                        secondSums += diagonal2;
                    }
                    System.out.print(firstSums);
                    System.out.println("The determinant is: " + (firstSums - secondSums));
                }
            }
            if(userInput == 7) {
                in = new Scanner(System.in);
                System.out.println("What are the dimensions of the matrix?");
                System.out.println("Number of rows: ");
                int rows = in.nextInt();
                System.out.println("Number of columns: ");
                int columns = in.nextInt();
                if(rows + 1 != columns) {
                        System.out.println("Not valid matrix dimensions");
                        break;
                }
                double [][] matrix = new double [rows][columns];//build new matrix size depending on input
                for(int i = 0; i < rows; i++) { //input values for matrix
                    System.out.println(rows + "x" + columns + ":" + " Enter " + columns + " values for row " + (i + 1));
                    for(int j = 0 ; j < columns; j++) {
                        matrix[i][j] = in.nextDouble();
                    }
                }
                for(int i = 0; i < columns - 1; i++) {
                    for(int j = 0 ; j < rows; j++) {
                        double pivot = matrix[j][i] / matrix [i][i];
                        for(int k = 0; k < rows; k++) {
                                matrix[j][k] = matrix[j][k] - matrix[i][k] * pivot;
                        }
                    }            
                }
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < columns; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
            System.out.println("Enter '1' to rerun, or any other key and then enter to end.");//rerun
            if(in.hasNextInt() && in.nextInt() == 1) {
                continue;
            } else {
                break;
            }
        }
    }
}

