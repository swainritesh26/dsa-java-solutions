package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class UnionOf2SortedArray {

    // 🔹 Approach 1: Using HashSet (Brute force)
    // Time: O((n1 + n2) log(n)) due to set insertion
    // Space: O(n1 + n2)
    public static int[] unionArray1(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();

        // add all elements of arr1
        for (int num1 : arr1) {
            st.add(num1);
        }

        // add all elements of arr2
        for (int num2 : arr2) {
            st.add(num2);
        }

        // convert set to array
        int[] arr = new int[st.size()];
        int i = 0;
        for (int num : st) {
            arr[i++] = num;
        }
        return arr;
    }

    // 🔹 Approach 2: Optimal — Two Pointer Technique (O(n1 + n2))
    // Works because arrays are already sorted
    public static int[] unionArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        // traverse both arrays together
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                // add unique element from arr1
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                    result.add(arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                // add unique element from arr2
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j])
                    result.add(arr2[j]);
                j++;
            }
            else { // both elements are same
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                    result.add(arr1[i]);
                i++;
                j++;
            }
        }

        // add remaining elements from arr1
        while (i < arr1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                result.add(arr1[i]);
            i++;
        }

        // add remaining elements from arr2
        while (j < arr2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j])
                result.add(arr2[j]);
            j++;
        }

        // convert list to array
        int[] union = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            union[k] = result.get(k);
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 7};
        System.out.println(Arrays.toString(unionArray(arr1, arr2)));
    }
}