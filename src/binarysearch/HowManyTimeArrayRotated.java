package binarysearch;

public class HowManyTimeArrayRotated {

    // Brute Force O(n):
    // Simply find the minimum element and return its index.
    // Because the index of minimum element = number of rotations.
    public static int findKRotation1(int[] arr) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                ans = i; // store index of a minimum
            }
        }
        return ans;
    }

    // Optimized O(log n):
    // Using Binary Search:
    // - If the array is already sorted, the first element is the minimum.
    // - Otherwise, search in the unsorted half where the minimum lies.
    public static int findKRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE; // track minimum value
        int idx = -1;                // track index of a minimum

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: Current subarray is sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    idx = low; // minimum at 'low'
                }
                break; // stop because this subarray is sorted
            }

            // Case 2: Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    idx = low;
                }
                low = mid + 1; // search in right half
            }

            // Case 3: Right half is sorted (so min must be in left half including mid)
            else {
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    idx = mid;
                }
                high = mid - 1; // search in left half
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(findKRotation1(arr)); // Brute Force
        System.out.println(findKRotation(arr));  // Optimized
    }
}
