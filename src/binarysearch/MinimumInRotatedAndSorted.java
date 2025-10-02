package binarysearch;

public class MinimumInRotatedAndSorted {

    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int minValue = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Find middle index

            // Case 1: If the current search space is already sorted,
            // then the leftmost element is the minimum in this range.
            if (arr[low] <= arr[high]) {
                minValue = Math.min(minValue, arr[low]);
                break; // No need to search further
            }

            // Case 2: Left half is sorted
            if (arr[low] <= arr[mid]) {
                // Update minimum with the smallest in left half
                minValue = Math.min(minValue, arr[low]);
                // Discard left half and move to right half
                low = mid + 1;
            }
            // Case 3: Right half is sorted
            else {
                // Update minimum with the middle element
                minValue = Math.min(minValue, arr[mid]);
                // Discard right half and move to left half
                high = mid - 1;
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 15, 17};
        System.out.println(findMin(arr));
    }
}
