package arrays;

public class SearchInTwoDMatrix {

    // Brute force: O(n^2) Brute Force
    public static boolean searchMatrix1(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimized: Binary Search O(log(m*n))  Optimal
    public static boolean searchMatrix(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int r = mid / cols;  // row index: number of full rows before this index
            int c = mid % cols;  // column index: position within the current row

            if (arr[r][c] == target) {
                return true;
            } else if (arr[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 8;

        System.out.println(searchMatrix1(arr, target));
        System.out.println(searchMatrix(arr, target));
    }
}
