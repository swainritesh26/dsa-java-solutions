package binarysearch;

public class SmallestDivisorGivenThreshold {

    // 🧮 Brute Force Approach: Check every possible divisor from 1 to max element
    public static int smallestDivisor1(int[] arr, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int k : arr) {
                sum += (int) Math.ceil((double) k / (double) i);
            }
            if (sum <= threshold) {
                return i;
            }
        }
        return -1;
    }

    // ✅ Optimal Approach using Binary Search
    public static int smallestDivisor(int[] arr, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        int low = 1, high = max, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate a total sum using the current divisor mid
            if (calculateSumWithDivisor(arr, mid) <= threshold) {
                ans = mid;          // mid is valid, try to find smaller divisor
                high = mid - 1;
            } else {
                low = mid + 1;      // mid too small, need larger divisor
            }
        }
        return ans;
    }

    // 💡 Helper Function: Returns total sum of ceil(arr[i] / divisor)
    public static int calculateSumWithDivisor(int[] arr, int divisor) {
        int total = 0;
        for (int num : arr) {
            total += (int) Math.ceil((double) num / (double) divisor);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(arr, threshold));  // ✅ Output: 5
    }
}
