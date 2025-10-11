package binarysearch;

/**
 * Problem: Find the row with the maximum number of 1s in a binary matrix.
 * Each row of the matrix is sorted (0s come before 1s).

 * Approaches:
 * 1️⃣ Brute Force → Count 1 s in every row (O(n * m))
 * 2️⃣ Optimized using Binary Search (O(n * log m))
 */
public class FindRowWithMax1 {

    // 🔹 Brute Force approach (O(n * m))
    public static int rowWithMax1sBrute(int[][] arr) {
        int max = -1; // max number of 1s found so far
        int ind = -1; // index of row having max 1s
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j]; // count number of 1s
            }
            if (count > max) {
                max = count;
                ind = i;
            }
        }
        return ind; // return row index having maximum 1s
    }

    // 🔹 Optimized Binary Search approach (O(n * log m))
    // Uses the property that each row is sorted → apply binary search to find first 1.
    public static int rowWithMax1s(int[][] arr) {
        int index = 0;  // store row index with max 1 s
        int maxCnt = -1; // max number of 1 s found so far

        for (int i = 0; i < arr.length; i++) {
            // find index of first occurrence of 1 in the row
            int firstOneIndex = lowerBound(arr[i], 1);
            // number of 1s = total columns - index of first 1
            int cnt = arr[i].length - firstOneIndex;

            if (cnt > maxCnt) {
                maxCnt = cnt;
                index = i;
            }
        }
        return index;
    }

    /**
     * Custom lowerBound function:
     * Finds the first index in sorted array 'arr' where element >= x
     * (In this problem, we find first 1)
     */
    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // default: if 1 not found, return length

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;      // possible answer (first 1)
                high = mid - 1; // go left to find earlier 1
            } else {
                low = mid + 1;  // move right if value < 1
            }
        }
        return ans;
    }

    // 🔹 Example run
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };

        System.out.println(rowWithMax1s(arr));
    }
}