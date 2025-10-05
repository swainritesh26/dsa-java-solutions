package binarysearch;

public class NumberOfDaysToMakeBouquets {

    // 🌸 Brute Force Approach: Check every possible day between min and max bloom day
    public static int minDays1(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the earliest and latest bloom day
        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Try every day to see when we can first make all m bouquets
        for (int day = min; day <= max; day++) {
            if (possible(bloomDay, day, m, k)) {
                return day;
            }
        }
        return -1;
    }

    // ✅ Helper Function: Checks if it's possible to make m bouquets on a given day
    public static boolean possible(int[] arr, int day, int m, int k) {
        int count = 0;       // Count of consecutive bloomed flowers
        int bouquets = 0;    // Number of bouquets formed

        for (int num : arr) {
            if (num <= day) {
                count++; // Flower bloomed → part of the current bouquet
            } else {
                bouquets += (count / k); // Form bouquets with a previous group
                count = 0; // Reset when a flower hasn’t bloomed
            }
        }
        bouquets += (count / k); // Add leftover bouquets (if any)
        return bouquets >= m; // True if we can make required bouquets
    }

    // 🌹 Optimal Approach: Binary Search on days
    public static int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max bloom days
        for (int num : bloomDay) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int ans = -1;
        int low = min, high = max;

        // Binary Search between the earliest and latest day
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if possible to make all bouquets by 'mid' day
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;       // midday works → try smaller day
                high = mid - 1;
            } else {
                low = mid + 1;   // Not enough bouquets → need more days
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(arr, m, k)); // ✅ Output: 3
    }
}
