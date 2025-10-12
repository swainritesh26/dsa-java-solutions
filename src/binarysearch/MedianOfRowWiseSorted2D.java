package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfRowWiseSorted2D {

    // 🧠 Brute Force Approach (O(n*m log(n*m)))
    // → Flatten the 2D array into a list.
    // → Sort the list.
    // → Return the middle element (median).
    public static int findMedian1(int[][] arr) {
        List<Integer> ls = new ArrayList<>();
        for (int[] row : arr) {
            for (int ele : row) {
                ls.add(ele);
            }
        }
        Collections.sort(ls);
        int n = arr.length * arr[0].length;
        return ls.get(n / 2);
    }

    // ⚡ Optimized Approach using Binary Search (O(32 * n * log m))
    // → Since each row is sorted, we can apply binary search on the value range.
    // Steps:
    // 1️⃣ Find the minimum and maximum elements (value range).
    // 2️⃣ Perform binary search on this value range.
    // 3️⃣ For each mid, count how many elements ≤ mid.
    // 4️⃣ If count ≤ required elements (n*m/2), move right; else left.
    // 5️⃣ When low > high, ‘low’ will hold the median.
    public static int findMedian(int[][] arr) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find global min and max values in matrix
        for (int[] row : arr) {
            low = Math.min(low, row[0]); // smallest in the first column
            high = Math.max(high, row[row.length - 1]); // largest in the last column
        }

        int total = arr.length * arr[0].length;
        int req = total / 2; // median position

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEqual(arr, mid);

            if (smallEqual <= req) {
                low = mid + 1; // too few small numbers → move right
            } else {
                high = mid - 1; // too many small numbers → move left
            }
        }
        return low; // ‘low’ will point to the median value
    }

    // Helper: Count elements ≤ x in the entire 2D matrix
    public static int countSmallEqual(int[][] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += upperBound(arr[i], x);
        }
        return count;
    }

    // Helper: Return index of first element > x (like C++ upper_bound)
    // → So count of ≤ x = returned index.
    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid; // potential answer
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // 🧪 Driver Code
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}
        };
        // Expected Output: 3
        System.out.println(findMedian(arr));
    }
}