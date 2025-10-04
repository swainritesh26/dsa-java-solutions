package binarysearch;

public class NthRoot {

    // 🔹 Brute Force: O(M)
    // Try every number from 1 → M and find the highest i such that i^N ≤ M.
    public static int NthRootNumber1(int N, int M) {
        int ans = 1;
        for (int i = 1; i <= M; i++) {
            if (Math.pow(i, N) <= M) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    // 🔹 Optimal Approach: Binary Search (O(log M))
    // Find the integer part of the Nth root of M.
    public static int NthRootNumber(int N, int M) {
        int ans = 1;
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            double power = Math.pow(mid, N); // mid^N

            if (power == M) return mid; // perfect Nth root found
            if (power < M) {             // mid^N < M → move right
                ans = mid;
                low = mid + 1;
            } else {                     // mid^N > M → move left
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 3, M = 81;
        System.out.println(NthRootNumber(N, M));
    }
}
