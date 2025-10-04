package arrays;

import java.util.Arrays;

public class SetMatrix0 {

    // ❌ Brute Force Approach
    // Time: O((n*m)*(n+m)) | Space: O(1)
    // For every 0 found, mark its entire row and column as -1 (temporary)
    // Finally, convert all -1s to 0
    public static void setZeroes1(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    makeRow(arr, j);
                    makeCol(arr, i);
                }
            }
        }
        // Replace temporary -1 with actual 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    // Marks the given column as -1
    public static void makeRow(int[][] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] != 0) {
                arr[i][col] = -1;
            }
        }
    }

    // Marks the given row as -1
    public static void makeCol(int[][] arr, int row) {
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[row][i] != 0) {
                arr[row][i] = -1;
            }
        }
    }

    // ✅ Better Approach using extra space
    // Time: O(n*m) | Space: O(n + m)
    // Use two arrays to keep track of rows and columns that should be zero
    public static void setZeroes2(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[] row1 = new int[row];
        int[] col1 = new int[col];

        // Step 1: Mark rows and columns that contain a 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    row1[i] = 1;
                    col1[j] = 1;
                }
            }
        }

        // Step 2: Update cells to 0 if in marked row/column
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (row1[i] == 1 || col1[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    // ⚡ Optimal Approach (In-place using first row and first column as markers)
    // Time: O(n*m) | Space: O(1)
    public static void setZeroes(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int col0 = -1;  // flag for first column

        // Step 1: Mark rows and columns using first row and col
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col0 = 0;  // mark that first column also needs to be zero
                    }
                }
            }
        }

        // Step 2: Set matrix cells to 0 based on markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][0] == 0 || arr[0][j] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Handle first row separately
        if (arr[0][0] == 0) {
            Arrays.fill(arr[0], 0);
        }

        // Step 4: Handle first column separately
        if (col0 == 0) {
            for (int i = 0; i < row; i++) {
                arr[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {0, 3, 2, 5}
        };
        setZeroes(arr);
        for (int[] num : arr) {
            for (int k : num) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}