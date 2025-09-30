package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // Brute-force approach: O(n^2) time complexity
    public static int[] twoSumBrute(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j}; // return indices of the two numbers
                }
            }
        }
        return new int[]{-1, -1}; // return if no pair found
    }

    // Optimal approach using HashMap: O(n) time complexity
    public static int[] twoSumOptimal(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = target - arr[i];
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i}; // return indices
            }
            map.put(arr[i], i); // store number and its index
        }
        return new int[]{-1, -1}; // return if no pair found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // Using brute-force
        System.out.println(Arrays.toString(twoSumBrute(arr, target)));

        // Using optimal approach
        System.out.println(Arrays.toString(twoSumOptimal(arr, target)));
    }
}
