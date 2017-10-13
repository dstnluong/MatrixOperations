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
            System.out.println("6) Reduced-Row Echelon Form");
            System.out.println("7) Inverse");
            int userInput = in.nextInt(); // depending on input, move to relevant part of code
            if(userInput == 1) {
                System.out.println("Enter number of rows and columns"); // ipnut
                int row = in.nextInt();
                int column = in.nextInt();
                
                double[][] matrix = new double[row][column];
                
                for (int i = 0; i < row; i++) {
                    System.out.println("Enter " + column + " values for row " + i);
                    for (int j = 0; j < column; j++) {
                    matrix[i][j] = in.nextDouble();
                    }
                }
         
                System.out.println("Enter scalar to multply with matrix");
                double scalar = in.nextDouble();
                // multplies scalar to each entry
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        matrix[i][j] *= scalar;
                    }
                }
        
                // alignment code
                int[] columnLength = new int[column];
        
                for (int i = 0; i < column; i++) {
                    String firstEntry = matrix[0][i] + "";
                    int maxLength = firstEntry.length();
                    for (int j = 0; j < row; j++) {
                        String compare = matrix[j][i] + "";
                        maxLength = Math.max(maxLength, compare.length());
                    }
                    columnLength[i] = maxLength;
                }   
            
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                    System.out.print(matrix[i][j]);
                    String placeHolder = matrix[i][j] + "";
                    int k = 0;
                        while(placeHolder.length() + k <= columnLength[j]) {
                            System.out.print(" ");
                            k++;
                        }
                    }
                    System.out.println();
                }
            }
            if(userInput == 2) { //Determinant
                in = new Scanner(System.in);
                System.out.println("Press 2 for a 2x2 matrix. Press 3 for a 3x3 matrix");
                int choice = in.nextInt();
                double[][] matrix = new double[choice][choice];//build new matrix size depending on input
                for(int i = 0; i < choice; i++) { //input values for matrix
                    System.out.println(choice + "x" + choice + ":" + " Enter " + choice + " values for row " + (i + 1));
                    for(int j = 0 ; j < choice; j++) {
                        matrix[i][j] = in.nextDouble();
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
            if(userInput == 3) {
                System.out.println("Enter number of rows and columns");
                int row = in.nextInt();
                int column = in.nextInt();
                double[][] matrix1 = new double[row][column];
                    for (int i = 0; i < row; i++) {
                        System.out.print("Matrix 1: " + "Enter " + column + " values for row " + i);
                        for (int j = 0; j < column; j++) {
                            matrix1[i][j] = in.nextDouble();
                        }
                    }

                double[][] matrix2 = new double[row][column];
                for (int i = 0; i < row; i++) {
                    System.out.print("Matrix 2: " + "Enter " + column + " values for row " + i);
                    for (int j = 0; j < column; j++) {
                        matrix2[i][j] = in.nextDouble();
                    }
                }

                System.out.println("This is the sum");
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                    matrix1[i][j] += matrix2[i][j];
                    }
                }
        
                // alignment code
                int[] columnLength = new int[column];
        
                for (int i = 0; i < column; i++) {
                    String firstEntry = matrix1[0][i] + "";
                    int maxLength = firstEntry.length();
                    for (int j = 0; j < row; j++) {
                        String compare = matrix1[j][i] + "";
                        maxLength = Math.max(maxLength, compare.length());
                    }
                    columnLength[i] = maxLength;
                }   
        
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(matrix1[i][j]);
                        String placeHolder = matrix1[i][j] + "";
                        int k = 0;
                        while(placeHolder.length() + k <= columnLength[j]) {
                        System.out.print(" ");
                        k++;
                        }
                    }
                System.out.println();
                }
            }
            if(userInput == 4) {
                System.out.println("Enter number of rows and columns");
                int row = in.nextInt();
                int column = in.nextInt();
        
                System.out.println("This program calculates Matrix 1 - Matrix 2");
                double[][] matrix1 = new double[row][column];
                for (int i = 0; i < row; i++){
                    System.out.print("Matrix 1: " + "Enter " + column + " values for row " + i);
                    for (int j = 0; j < column; j++) {
                        matrix1[i][j] = in.nextDouble();
                    }
                }

                double[][] matrix2 = new double[row][column];
                for (int i = 0; i < row; i++){
                    System.out.print("Matrix 2: " + "Enter " + column + " values for row " + i);
                    for (int j = 0; j < column; j++) {
                        matrix2[i][j] = in.nextDouble();
                    }
                }

                System.out.println("This is the difference");
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        matrix1[i][j] = matrix1[i][j] - matrix2[i][j];
                    }
                }

                // alignment code
                double[] columnLength = new double[column];
        
                for (int i = 0; i < column; i++){
                    String firstEntry = matrix1[0][i] + "";
                    int maxLength = firstEntry.length();
                    for (int j = 0; j < row; j++) {
                        String compare = matrix1[j][i] + "";
                        maxLength = Math.max(maxLength, compare.length());
                    }
                    columnLength[i] = maxLength;
                }   
        
                for (int i = 0; i < row; i++){
                    for (int j = 0; j < column; j++){
                        System.out.print(matrix1[i][j]);
                        String placeHolder = matrix1[i][j] + "";
                        int k = 0;
                        while(placeHolder.length() + k <= columnLength[j]){
                            System.out.print(" ");
                            k++;
                        }
                    }
                    System.out.println();
                }
            }
            if(userInput == 5) {
                System.out.println("Matrix 1: Enter number of rows and columns");
                int row1 = in.nextInt();
                int column1 = in.nextInt();

                double[][] matrix1 = new double[row1][column1];

                for (int i = 0; i < row1; i++) {
                    System.out.print("Matrix 1: " + "Enter " + column1 + " values for row " + (i+1));
                    for (int j = 0; j < column1; j++) {
                        matrix1[i][j] = in.nextDouble();
                    }  
                }

                System.out.println("Matrix 2: Enter number of rows and columns");
                int row2 = in.nextInt();
                int column2 = in.nextInt();
                double[][] matrix2 = new double[row2][column2];

                for (int i = 0; i < row2; i++) {
                    System.out.print("Matrix 2: " + "Enter " + column2 + " values for row " + (i + 1));
                    for (int j = 0; j < column2; j++) {
                        matrix2[i][j] = in.nextDouble();
                    }
                }

                if (column1 == row2) {
                    double[][] product = new double[row1][column2]; 
                    for (int i = 0; i < row1; i++) {
                        for (int j = 0; j < column2; j++) {
                        int sum = 0;
                            for (int k = 0; k < column1; k++) {
                                sum += matrix1[i][k] * matrix2[k][j];
                            }
                        product[i][j] = sum;
                        }
                    }

                    // alignment code
                    int[] columnLength = new int[column2];

                    for (int i = 0; i < column2; i++) {
                        String firstEntry = product[0][i] + "";
                        int maxLength = firstEntry.length();
                        for (int j = 0; j < row1; j++) {
                            String compare = product[j][i] + "";
                            maxLength = Math.max(maxLength, compare.length());
                        }
                        columnLength[i] = maxLength;
                    }   

                    for (int i = 0; i < row1; i++) {
                        for (int j = 0; j < column2; j++){
                            System.out.print(product[i][j]);
                            String placeHolder = product[i][j] + "";
                            int k = 0;
                            while(placeHolder.length() + k <= columnLength[j]){
                                System.out.print(" ");
                                k++;
                            }
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Cannot be multplied");
                }
            }
            if(userInput == 6) {
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
                double[][] temp = matrix.clone(); // put non-zero numbers into the pivot squares
                for (int i = 0; i < rows; i++) {
                    if (matrix[i][i] == 0) {
                        for (int j = 0; j < rows; j++) {
                            if (matrix [j][i] != 0) {
                                double tmpRow[] = matrix[i];
                                matrix[i] = matrix[j];
                                matrix[j] = tmpRow;
                            }
                        }
                    }
                }
                for(int i = 0; i < columns - 1; i++) { // solve matrix
                    for(int j = 0 ; j < rows; j++) {
                        double pivot = matrix[j][i] / matrix[i][i];
                        for(int k = 0; k < columns; k++) {
                            if(i != j) {
                                matrix[j][k] = matrix[j][k] - matrix[i][k] * pivot;
                            }
                        }
                    }            
                }
                for(int i = 0; i < rows; i++) {
                    double pivot = matrix[i][i];
                    for(int j = 0; j < columns; j++) {
                        matrix[i][j] = matrix[i][j] / pivot;
                    }
                }
                // alignment code
                int[] columnLength = new int[columns];

                for (int i = 0; i < columns; i++) {
                    String firstEntry = matrix[0][i] + "";
                    int maxLength = firstEntry.length();
                    for (int j = 0; j < rows; j++) {
                        String compare = matrix[j][i] + "";
                        maxLength = Math.max(maxLength, compare.length());
                    }
                    columnLength[i] = maxLength;
                }   

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++){
                        System.out.print(matrix[i][j]);
                        String placeHolder = matrix[i][j] + "";
                        int k = 0;
                        while(placeHolder.length() + k <= columnLength[j]){
                            System.out.print(" ");
                            k++;
                        }
                    }
                    System.out.println();
                }
            }
            if(userInput == 7) {
                in = new Scanner(System.in);
                System.out.println("What is the size of the matrix?");
                int size = in.nextInt();
                
                double [][] matrix = new double [size][size];//build new matrix size depending on input
                for(int i = 0; i < size; i++) { //input values for matrix
                    System.out.println(size + "x" + size + ":" + " Enter " + size + " values for row " + (i + 1));
                    for(int j = 0 ; j < size; j++) {
                        matrix[i][j] = in.nextDouble();
                    }
                }
                double[][] temp = matrix.clone(); // put non-zero numbers into the pivot squares
                for (int i = 0; i < size; i++) {
                    if (matrix[i][i] == 0) {
                        for (int j = 0; j < size; j++) {
                            if (matrix [j][i] != 0) {
                                double tmpRow[] = matrix[i];
                                matrix[i] = matrix[j];
                                matrix[j] = tmpRow;
                            }
                        }
                    }
                }
                double[][] inverse = new double [size][size * 2];
                for(int i = 0; i < size; i ++) { //copy matrix to left side
                    for (int j = 0; j < size; j++) {
                        inverse[i][j] = matrix[i][j];
                    }
                }
                for(int i = 0; i < size; i++) { //add indentity matrix to the right side
                        inverse[i][i + size] = 1;
                }
                for(int i = 0; i < size;i++) { // put left side into RREF
                    for(int j = 0 ; j < size; j++) {
                        double pivot = inverse[j][i] / inverse[i][i];
                        for(int k = 0; k < size * 2; k++) {
                            if(i != j) {
                                inverse[j][k] = inverse[j][k] - inverse[i][k] * pivot;
                            }
                        }
                    }            
                }
                for(int i = 0; i < size; i++) {
                    double pivot = inverse[i][i];
                    for(int j = 0; j < size * 2; j++) {
                        inverse[i][j] = inverse[i][j] / pivot;
                    }
                }

                // alignment code
                int[] columnLength = new int[size * 2];

                for (int i = 0; i < size * 2; i++) {
                    String firstEntry = inverse[0][i] + "";
                    int maxLength = firstEntry.length();
                    for (int j = 0; j < size; j++) {
                        String compare = inverse[j][i] + "";
                        maxLength = Math.max(maxLength, compare.length());
                    }
                    columnLength[i] = maxLength;
                }   

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size * 2; j++){
                        System.out.print(inverse[i][j]);
                        String placeHolder = inverse[i][j] + "";
                        int k = 0;
                        while(placeHolder.length() + k <= columnLength[j]){
                            System.out.print(" ");
                            k++;
                        }
                    }
                    System.out.println();
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

