package com.nyu.oa.csico;

/**
 * Question
 * Write an algorithm to rotate the image by 90 degrees right.
 * lnput
 * The first line of the input consists of two space-separated integers - matrix_rows and matrix_cols, representing the
 * number of rows of the matrix(N) and number of columns of the matrix(M);
 * The next N lines consist of M space-separated integers, representing the pixel of the matrix.
 * Output
 * Print M lines consist of N space-separated integers representing the rotated image by 90 degrees.
 * Example
 * Input:
 * 3 3
 * 123
 * 456
 * 789
 * output:
 * 741
 * 852
 * 963
 */
public class RotateMatrix90Degrees {
    static int N = 4;

    static void rotate90Clockwise(int a[][]) {

        // Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    static void printMatrix(int arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

// Driver code

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate90Clockwise(arr);
        printMatrix(arr);
    }
}
