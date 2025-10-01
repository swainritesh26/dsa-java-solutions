package binarysearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    // Returns the first and last position of target in a sorted array
    public static int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int ans1 = -1, ans2 = -1;

        // Search for first occurrence
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans1 = mid;      // possible first occurrence
                high = mid - 1;  // keep looking in left half
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Search for last occurrence
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans2 = mid;     // possible last occurrence
                low = mid + 1;  // keep looking in the right half
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 7;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
