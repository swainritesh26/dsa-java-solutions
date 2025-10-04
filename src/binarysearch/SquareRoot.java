package binarysearch;

public class SquareRoot {

    // 🔹 Brute Force Approach: O(n)
    // Check every number i from 1 to n.
    // If i*i <= n, keep updating ans.
    // Stop once i*i > n.
    public static int floorSqrt1(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    // 🔹 Optimal Approach: Binary Search (O(log n))
    // Search for the largest mid such that mid*mid <= n.
    public static int floorSqrt(int n) {
        int ans = 1;
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if mid^2 <= n → possible answer
            if ((long) mid * mid <= n) {
                ans = mid;
                low = mid + 1; // try to find a larger square
            } else {
                high = mid - 1; // reduce the range
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 35;
        System.out.println(floorSqrt(n));
    }
}
