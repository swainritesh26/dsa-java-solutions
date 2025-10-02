package arrays;

import java.util.Arrays;

public class RearrangePositiveAndNegative {

    // Approach 1: Using two separate arrays for positives and negatives
    // T.C = O(n), S.C = O(n)
    public int[] rearrangeArray1(int[] arr) {
        int n = arr.length;
        int[] pos = new int[n/2];  // store positives
        int[] neg = new int[n/2];  // store negatives
        int i = 0, j = 0;

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num > 0) {
                pos[i++] = num;
            } else {
                neg[j++] = num;
            }
        }

        // Merge them alternately into a result array
        int h = 0, g = 0;
        int[] res = new int[n];
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                res[k] = pos[g++]; // place positive at even index
            } else {
                res[k] = neg[h++]; // place negative at odd index
            }
        }
        return res;
    }

    // Approach 2: More direct solution
    // Place positives at even indices, negatives at odd indices
    // T.C = O(n), S.C = O(n)
    public static int[] rearrangeArray(int[] arr) {
        int[] res = new int[arr.length];
        int p = 0, n = 1; // pointers for positive (even idx) and negative (odd idx)

        for (int num : arr) {
            if (num > 0) {
                res[p] = num;
                p += 2;
            } else { // num < 0
                res[n] = num;
                n += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}