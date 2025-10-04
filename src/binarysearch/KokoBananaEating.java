package binarysearch;

public class KokoBananaEating {

    // 🔹 Brute Force Approach (O(max(piles) * n))
    // Try every possible speed from 1 to max(piles) and return the minimum speed
    // that allows Koko to eat all bananas within h hours.
    public static int minEatingSpeed1(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(max, num);
        }

        for (int i = 1; i <= max; i++) {
            int totalHours = calculateTotalHours(piles, i);
            if (totalHours <= h) {
                return i; // first valid speed
            }
        }
        return -1;
    }

    // 🔹 Optimal Approach: Binary Search on Answer (O(n * log(max(piles))))
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(max, num);
        }

        int low = 1;           // Minimum possible speed
        int high = max;        // Maximum possible speed
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Mid represents the current eating speed
            int totalHours = calculateTotalHours(piles, mid);

            // If Koko can finish with this speed, try a smaller one
            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            } else { // Otherwise, she’s too slow → increase speed
                low = mid + 1;
            }
        }
        return ans;
    }

    // Helper function to calculate total hours Koko needs at a given speed
    public static int calculateTotalHours(int[] arr, int speed) {
        int totalH = 0;
        for (int num : arr) {
            // Use ceiling because even if there are leftover bananas, it still takes a full hour
            totalH += (int) Math.ceil((double) num / (double) speed);
        }
        return totalH;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(arr, h));
    }
}
