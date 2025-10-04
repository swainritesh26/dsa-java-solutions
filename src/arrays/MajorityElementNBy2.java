package arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementNBy2 {

    // 🔹 Brute Force using HashMap — O(n) time, O(n) space
    // Count frequency of each element and return the one with count > n/2
    public static int majorityElement1(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);

            // As soon as any element counts > n/2, return it
            if (mp.get(num) > arr.length / 2) {
                return num;
            }
        }
        return -1; // If no majority element (though question guarantees one)
    }

    // 🔹 Optimal Approach — Moore’s Voting Algorithm (O(n) time, O(1) space)
    // Intuition: Majority element appears more than n/2 times,
    // so it will "cancel out" all others and remain in the end.
    public static int majorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find potential candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num; // choose new candidate
            }

            // increase or decrease count based on match
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Return candidate (guaranteed to be majority per problem)
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }
}
