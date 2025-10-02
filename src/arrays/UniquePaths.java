package arrays;

public class UniquePaths {

    // Brute Force: Recursion (Exponential time)
    // At each step, we can only move right or down
    public static int uniquePathsBrute(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    private static int countPaths(int i, int j, int m, int n) {
        // If out of bounds → no path
        if (i >= m || j >= n) return 0;

        // If we reached destination → 1 path found
        if (i == m - 1 && j == n - 1) return 1;

        // Move right + Move down
        return countPaths(i + 1, j, m, n) + countPaths(i, j + 1, m, n);
    }

    // Optimal: Tabulation DP (Bottom-up)
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base case: 1 way for first row and first col
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(uniquePathsBrute(m, n));
        System.out.println(uniquePaths(m, n));
    }
}
