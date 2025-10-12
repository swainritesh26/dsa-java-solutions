package binarysearch;

import java.util.Arrays;

public class PeakElement2DArray {

    // 🧠 Brute Force Approach (O(n * m))
    // → Check every element in the matrix.
    // → Keep track of the maximum element and its coordinates.
    // → That element will be the peak.
    public static int[] findPeakGrid1(int[][] arr) {
        int max = Integer.MIN_VALUE, a = 0, b = 0;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    a = i;
                    b = j;
                }
            }
        }
        return new int[]{a, b}; // return coordinates of peak
    }

    // ⚡ Optimized Binary Search Approach (O(n * log m))
    // → Idea: Apply binary search on columns
    // → For each column:
    //     1️⃣ Find the row having the maximum element in that column.
    //     2️⃣ Compare that element with its left and right neighbors.
    // → If it’s greater than both → peak found.
    // → Else move towards the larger neighbor.
    public static int[] findPeakGrid(int[][] arr) {
        int low = 0, high = arr[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find the row having the maximum element in current column
            int row = maximumEle(arr, mid);

            // Get left and right elements (if exist)
            int left = mid - 1 >= 0 ? arr[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < arr[0].length ? arr[row][mid + 1] : Integer.MIN_VALUE;

            // Check if the current element is greater than both neighbors
            if (arr[row][mid] > left && arr[row][mid] > right) {
                return new int[]{row, mid}; // Peak found
            }
            // Move towards the direction of greater neighbor
            else if (left > arr[row][mid]) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return new int[]{-1, -1}; // No peak found (an edge case)
    }

    // Helper function: Finds the row index having the maximum element in given column
    public static int maximumEle(int[][] arr, int col) {
        int max = Integer.MIN_VALUE, index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
                index = i;
            }
        }
        return index;
    }

    // 🧪 Driver Code
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        };

        // Expected Output: [1, 1] → Peak element = 30
        System.out.println(Arrays.toString(findPeakGrid(arr)));
    }
}