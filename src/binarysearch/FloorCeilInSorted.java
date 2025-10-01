package binarysearch;

import java.util.Arrays;

public class FloorCeilInSorted {

    // Returns floor and ceil of x in a sorted array
    // floor = greatest element <= x
    // ceil  = smallest element >= x
    public static int[] getFloorAndCeil(int[] arr, int x) {
        int n = arr.length;
        int ans1 = -1, ans2 = -1; // floor, ceil
        int low = 0, high = n - 1;

        // Find a floor
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans1 = arr[mid];   // possible floor
                low = mid + 1;     // move right
            } else {
                high = mid - 1;    // move left
            }
        }

        // Reset pointers for ceil
        low = 0;
        high = n - 1;

        // Find ceil
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans2 = arr[mid];   // possible ceil
                high = mid - 1;    // move left
            } else {
                low = mid + 1;     // move right
            }
        }

        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 1;

        System.out.println(Arrays.toString(getFloorAndCeil(arr, x)));
    }
}