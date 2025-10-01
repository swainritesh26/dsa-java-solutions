package binarysearch;


public class CountOccurrences {

    // Helper method: returns first and last position of target
    public static int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int ans1 = -1, ans2 = -1;

        // First occurrence
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans1 = mid;
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Last occurrence
        low = 0; high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans2 = mid;
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{ans1, ans2};
    }

    // Main method: counts total occurrences of target
    public static int countOccurrences(int[] arr, int target) {
        int[] pos = searchRange(arr, target);
        if (pos[0] == -1 || pos[1] == -1) {
            return 0; // target not found
        }
        return pos[1] - pos[0] + 1; // count = lastIndex - firstIndex + 1
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 3};
        int target = 1;
        System.out.println(countOccurrences(arr, target)); // Output: 3
    }
}
