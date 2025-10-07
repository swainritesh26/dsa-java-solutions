package binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    // 🔹 Brute Force Approach - O(n * (max-min))
    public static int aggressiveCows1(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); // sort stall positions
        int limit = arr[n - 1] - arr[0]; // max possible distance
        // try every possible distance from 1 to limit
        for (int i = 1; i <= limit; i++) {
            // if we can't place cows at distance i, return i-1
            if (!canWePlace(arr, i, k)) return i - 1;
        }
        return limit;
    }

    // helper function: checks if cows can be placed with at least 'dist' distance
    public static boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows = 1;   // place first cow at first stall
        int last = arr[0]; // position of last placed cow
        for (int num : arr) {
            // place next cow if distance condition satisfies
            if (num - last >= dist) {
                cntCows++;
                last = num;
            }
            // if all cows placed successfully
            if (cntCows >= cows) return true;
        }
        return false;
    }

    // 🔹 Optimized Approach - Binary Search on Answer
    public static int aggressiveCows(int[] arr, int k) {
        int n = arr.length, ans = 0;
        Arrays.sort(arr); // sort stall positions
        int limit = arr[n - 1] - arr[0];
        int low = 1;        // minimum possible distance
        int high = limit;   // maximum possible distance

        // binary search to find the largest minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2; // mid = possible minimum distance

            if (!canWePlace(arr, mid, k)) {
                // if we can’t place cows → reduce distance
                high = mid - 1;
            } else {
                // if we can place cows → try for larger distance
                ans = mid;
                low = mid + 1;
            }
        }
        return ans; // maximum minimum distance
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(arr, 4));
    }
}
