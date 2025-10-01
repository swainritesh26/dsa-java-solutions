package arrays;

public class RotateMatrix90 {

    // Method 1: Using extra space (O(n^2))
    public static void rotate1(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] dummy = new int[row][col];

        // Place each element in its rotated position
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dummy[j][row - i - 1] = arr[i][j];
            }
        }

        // Copy back to original matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = dummy[i][j];
            }
        }
    }

    // Method 2: In-place rotation (O(1) extra space)
    public static void rotate(int[][] arr) {
        int n = arr.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(arr); // in-place rotation

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
