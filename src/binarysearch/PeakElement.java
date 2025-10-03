package binarysearch;

public class PeakElement {

    // Brute Force O(n):
    // Simply check each element (except boundaries) if it's greater than its neighbors.
    public static int findPeakElement1(int[] arr) {
        for (int i = arr.length - 2; i >= 1; i--) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return i; // return index of peak
            }
        }
        return -1; // no peak found (should not happen in valid input)
    }

    // Optimized Binary Search O(log n):
    // Idea: A peak exists if arr[mid] > neighbors.
    // Otherwise, move to the side where a peak must exist.
    public static int findPeakElement(int[] arr) {
        int n = arr.length;

        // Handle edge cases: the first or last element can be a peak
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1;       // exclude 0 (already checked)
        int high = n - 2;  // exclude n-1 (already checked)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If the right neighbor is bigger, move right
            // Because a peak must exist in that direction
            if (arr[mid] > arr[mid + 1]) {
                low = mid + 1;
            } else {
                // Else move left
                high = mid - 1;
            }
        }
        return -1; // should never reach here
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr));
    }
}
