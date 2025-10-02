package binarysearch;

public class SearchInRotatedArray {

    // Function to search in a rotated sorted array
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // found target
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1; // target lies in left half
                } else {
                    low = mid + 1;  // target lies in right half
                }
            }
            // Else right half is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;  // target lies in right half
                } else {
                    high = mid - 1; // target lies in left half
                }
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int target = 4;
        System.out.println(search(arr, target));
    }
}
