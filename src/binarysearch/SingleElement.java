package binarysearch;

public class SingleElement {

    // Brute Force: Check neighbors for each element
    // T.C = O(n), S.C = O(1)
    public static int singleNonDuplicate1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    // Better: Use XOR property
    // T.C = O(n), S.C = O(1)
    // Pairs cancel each other, only a single element remains
    public static int singleNonDuplicate2(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }

    // Optimal: Binary Search
    // T.C = O(log n), S.C = O(1)
    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        // Edge cases: single element or at boundaries
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the single element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];

            // Idea:
            // Before a single element: pairs start at even index
            // After a single element: pairs start at odd index
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;  // single element is to the right
            } else {
                high = mid - 1; // single element is to the left
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(arr));
    }
}