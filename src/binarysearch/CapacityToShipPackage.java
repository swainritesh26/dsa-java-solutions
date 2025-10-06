package binarysearch;

public class CapacityToShipPackage {

    // 🔹 Brute Force: Try every capacity from max(weights) to sum(weights)
    public static int shipWithinDays1(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : weights) {
            max = Math.max(max, num);
            sum += num;
        }

        for (int cap = max; cap <= sum; cap++) {
            int dayReq = daysRequired(weights, cap);
            if (dayReq <= days) {
                return cap;  // we need the minimum capacity
            }
        }
        return -1;
    }

    // 🔹 Helper function: Calculate days needed for given ship capacity
    public static int daysRequired(int[] arr, int cap) {
        int days = 1, load = 0;
        for (int num : arr) {
            // If the current load exceeds capacity → start a new day
            if (load + num > cap) {
                days += 1;
                load = num;
            } else {
                load += num;
            }
        }
        return days;
    }

    // 🔹 Optimized using Binary Search
    public static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Find range of capacity
        for (int num : weights) {
            sum += num;
            max = Math.max(max, num);
        }

        int low = max;  // Minimum possible capacity
        int high = sum; // Maximum possible capacity
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numberOfDays = daysRequired(weights, mid);

            if (numberOfDays <= days) {
                ans = mid;     // ✅ Possible answer, try smaller capacity
                high = mid - 1;
            } else {
                low = mid + 1; // ❌ Too small, increase capacity
            }
        }

        return ans;  // ✅ Return minimum capacity
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr, 5));  // ✅ Output: 15
    }
}
