package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementNBy3 {

    // 🧠 Brute Force Approach using HashMap (O(N) Time, O(N) Space)
    public static List<Integer> majorityElement(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Add all elements appearing more than ⌊n/3⌋ times
        for (int key : mp.keySet()) {
            if (mp.get(key) > arr.length / 3) {
                ls.add(key);
            }
        }

        return ls;
    }

    // ✅ Optimized Approach: Boyer–Moore Voting Algorithm (O(N) Time, O(1) Space)
    public static List<Integer> majorityElement1(int[] arr) {
        List<Integer> ls = new ArrayList<>();

        // Variables to store two potential candidates and their counts
        int count1 = 0, can1 = 0;
        int count2 = 0, can2 = 0;

        // Step 1: Find two potential majority candidates
        for (int num : arr) {
            if (num == can1) {
                count1++; // Increment count for candidate 1
            } else if (num == can2) {
                count2++; // Increment count for candidate 2
            } else if (count1 == 0) {
                // Assign new candidate 1
                can1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                // Assign new candidate 2
                can2 = num;
                count2 = 1;
            } else {
                // If both have non-zero counts and current element matches neither,
                // decrease both counts
                count1--;
                count2--;
            }
        }

        // Step 2: Verify actual counts of the candidates
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == can1) count1++;
            else if (num == can2) count2++;
        }

        // Step 3: Check if counts are greater than ⌊n/3⌋
        if (count1 > arr.length / 3) {
            ls.add(can1);
        }
        if (count2 > arr.length / 3) {
            ls.add(can2);
        }

        return ls;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(majorityElement1(arr));  // Output: []
    }
}
