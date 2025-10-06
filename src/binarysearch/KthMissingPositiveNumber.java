package binarysearch;

public class KthMissingPositiveNumber {

    // ✅ Brute Force Approach — O(n)
    public static int findKthPositive1(int[] arr, int k) {
        // Loop through an array
        for (int num : arr) {
            // If the number is <= k, it means that number is present,
            // so the missing numbers shift by one position
            if (num <= k) k++;
            else break;
        }
        // Finally, k itself will be the kth missing number
        return k;
    }

    // ✅ Optimal Approach using Binary Search — O(log n)
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        // Perform binary search on index range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate how many numbers are missing until arr[mid]
            // Example: for arr[mid] = 4, index = 2 → missing = 4 - (2 + 1) = 1
            int missing = arr[mid] - (mid + 1);

            // If missing count < k, move right to find more missing numbers
            if (missing < k) {
                low = mid + 1;
            }
            // Otherwise, move left to find earlier missing position
            else {
                high = mid - 1;
            }
        }

        // Finally, the kth missing number is k + low
        // (because 'low' represents how many elements are ≤ the missing number)
        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(findKthPositive(arr, 5)); // ✅ Output: 9
    }
}
