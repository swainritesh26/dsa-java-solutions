package arrays;

import java.util.Arrays;

public class Sort012 {

    // Brute Force: Used library sort (O(n log n))
    public static void sortColors1(int[] arr) {
        Arrays.sort(arr);
    }

    // Better: Count number of 0s, 1s, 2s (O(2n) time, O(1) space)
    public static void sortColors2(int[] arr) {
        int count0=0, count1=0, count2=0;

        // Count frequency of 0,1,2
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Fill back into array
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }
        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    // Optimal: Dutch National Flag Algorithm (single pass, O(n), O(1) space)
    public static void sortColors(int[] arr) {
        int i = 0;              // boundary for 0s
        int j = 0;              // current index
        int k = arr.length - 1; // boundary for 2s

        while (j <= k) {
            if (arr[j] == 2) {
                swap(arr, j, k); // put 2 at the end
                k--;
            } else if (arr[j] == 0) {
                swap(arr, i, j); // put 0 at the beginning
                i++;
                j++;
            } else { // arr[j] == 1
                j++; // keep 1 in the middle
            }
        }
    }

    // Helper function for swapping
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
