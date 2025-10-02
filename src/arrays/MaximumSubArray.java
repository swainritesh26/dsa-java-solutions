package arrays;

public class MaximumSubArray {

    // Approach 1: Brute Force (O(n^3))
    // Try all subarrays and calculate sum
    public static int maxSubArray1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;  // handle negatives also
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];  // compute sum for subarray [i..j]
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Approach 2: Better (O(n^2))
    // Fix start index, expand end index, keep adding
    public static int maxSubArray2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];  // directly add instead of re-looping
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Approach 3: Optimal (Kadane’s Algorithm) O(n)
    // Keep running sum, reset if it goes negative
    public static int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);

            // If current sum becomes negative, reset it
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
