package binarysearch;

public class SplitSubArrayLargestSum {

    // 🔹 Brute Force approach (O(sum - max))
    public static int splitArray1(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Find the largest element (lower limit) and total sum (upper limit)
        for (int num : arr) {
            sum += num;
            max = Math.max(max, num);
        }

        // Try every possible max subarray sum from max → sum
        for (int i = max; i <= sum; i++) {
            if (countSubArray(arr, i) == k) {
                return i; // first valid max subarray sum
            }
        }
        return -1;
    }

    // Helper function → counts how many subarrays are needed
    // if each subarray's sum ≤ given limit (sum)
    public static int countSubArray(int[] arr, int sum) {
        int subArray = 1;   // start with one subarray
        int sumArray = 0;   // current subarray sum

        for (int num : arr) {
            if (sumArray + num <= sum) {
                sumArray += num;  // keep adding elements
            } else {
                subArray++;       // create a new subarray when limit exceeded
                sumArray = num;   // start new subarray
            }
        }
        return subArray;
    }

    // 🔹 Optimal approach using Binary Search (O(N * log(sum - max)))
    public static int splitArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Find search space boundaries
        for (int num : arr) {
            sum += num;
            max = Math.max(max, num);
        }

        int ans = -1;
        int low = max, high = sum;

        // Binary search for the smallest possible "maximum subarray sum"
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int subArrayCount = countSubArray(arr, mid);

            if (subArrayCount > k) {
                // Too many subarrays → capacity (mid) too small
                low = mid + 1;
            } else {
                // Possible answer → try a smaller maximum sum
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(arr, k)); // ✅ Output: 18
    }
}
