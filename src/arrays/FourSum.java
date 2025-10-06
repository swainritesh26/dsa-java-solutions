package arrays;

import java.util.*;

public class FourSum {

    // 🔹 Brute Force Approach — O(n⁴)
    // Try every possible combination of 4 numbers
    public static List<List<Integer>> fourSum1(int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>(); // to store unique quadruplets
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        int sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) { // found valid quadruplet
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            temp.sort(null); // sort to handle duplicates
                            st.add(temp); // set removes duplicates automatically
                        }
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }

    // 🔹 Better Approach — O(n³) using HashSet
    // Fix two numbers and use a HashSet for the remaining two
    public static List<List<Integer>> fourSum2(int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Set<Integer> hs = new HashSet<>(); // stores seen numbers
                for (int k = j + 1; k < arr.length; k++) {
                    int fourth = target - (arr[i] + arr[j] + arr[k]); // number needed for target sum
                    if (hs.contains(fourth)) { // found valid quadruplet
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        temp.sort(null); // sort to maintain order
                        st.add(temp);
                    }
                    hs.add(arr[k]); // store current element
                }
            }
        }
        return new ArrayList<>(st);
    }

    // 🔹 Optimal Approach — O(n³) using Sorting + Two Pointers
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr); // sorting helps skip duplicates and use two-pointer efficiently
        List<List<Integer>> ls = new ArrayList<>();
        long tgt = target; // using long to avoid integer overflow

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicates for i

            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue; // skip duplicates for j

                int k = j + 1;              // left pointer
                int l = arr.length - 1;     // right pointer

                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum == tgt) { // found valid quadruplet
                        ls.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;

                        // skip duplicate values for k and l
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;

                    } else if (sum > tgt) {
                        l--; // decrease sum
                    } else {
                        k++; // increase a sum
                    }
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr, 0));
    }
}
