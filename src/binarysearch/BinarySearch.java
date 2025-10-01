package binarysearch;

public class BinarySearch {

    // Binary search to find target in a sorted array
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (arr[mid] == target) {
                return mid; // target found
            } else if (arr[mid] > target) {
                right = mid - 1; // search left half
            } else {
                left = mid + 1; // search right half
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(arr, target));
    }
}
