package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray {

    // ✅ Approach 1: Brute Force (O((m+n) log(m+n)) time, O(m+n) space)
    // Combine both arrays and sort the result
    public static void merge1(int[] arr1, int m, int[] arr2, int n) {
        List<Integer> st = new ArrayList<>();

        // Add valid elements of arr1 (ignore trailing zeros)
        for (int i = 0; i < m; i++) {
            st.add(arr1[i]);
        }

        // Add all elements of arr2
        for (int num : arr2) {
            st.add(num);
        }

        // Sort the combined list
        st.sort(null);

        // Copy back into arr1
        for (int i = 0; i < st.size(); i++) {
            arr1[i] = st.get(i);
        }
    }

    // ✅ Approach 2: Optimal Solution (O(m+n) time, O(1) space)
    // Merge in-place from the end of arr1
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int l = m - 1;         // Pointer for last element in arr1 (before zeros)
        int r = n - 1;         // Pointer for last element in arr2
        int k = m + n - 1;     // Pointer for placement in arr1 from the end

        // Traverse from back, placing larger elements first
        while (l >= 0 && r >= 0) {
            if (arr1[l] > arr2[r]) {
                arr1[k] = arr1[l];
                l--;
            } else {
                arr1[k] = arr2[r];
                r--;
            }
            k--;
        }

        // If elements remain in arr2, copy them
        while (r >= 0) {
            arr1[k] = arr2[r];
            k--;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        // Brute Force
        merge1(arr1, 3, arr2, 3);
        System.out.println("Brute Force Output: " + Arrays.toString(arr1));

        // Reset and test optimal approach
        int[] arr3 = {1, 2, 3, 0, 0, 0};
        merge(arr3, 3, arr2, 3);
        System.out.println("Optimized Output: " + Arrays.toString(arr3));
    }
}
