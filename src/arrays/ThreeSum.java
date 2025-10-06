package arrays;

import java.util.*;

public class ThreeSum {

    // 🔹 Brute Force Approach — O(n³)
    public static List<List<Integer>> threeSum1(int[] arr) {
        Set<List<Integer>> st = new HashSet<>(); // to store unique triplets
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) { // found a triplet
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null); // sort to handle duplicates
                        st.add(temp); // add to set (duplicate auto removed)
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }

    // 🔹 Better Approach — O(n²) using HashSet
    public static List<List<Integer>> threeSum2(int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> hs = new HashSet<>(); // stores elements for current i
            for (int j = i + 1; j < arr.length; j++) {
                int third = -(arr[i] + arr[j]); // the number needed to make sum 0
                if (hs.contains(third)) { // found a triplet
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null); // sort before adding
                    st.add(temp);
                }
                hs.add(arr[j]); // add current number to set
            }
        }
        return new ArrayList<>(st);
    }

    // 🔹 Optimal Approach — O(n²) using Sorting + Two Pointers
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr); // sort array to easily skip duplicates
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicate values for i

            int j = i + 1;              // left pointer
            int k = arr.length - 1;     // right pointer

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == 0) { // found a valid triplet
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ls.add(temp);
                    j++;
                    k--;

                    // skip duplicate values for j and k
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;

                } else if (sum > 0) { // sum too large → decrease k
                    k--;
                } else {              // sum too small → increase j
                    j++;
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
