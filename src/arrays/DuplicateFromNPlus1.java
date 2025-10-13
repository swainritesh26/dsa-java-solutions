package arrays;

import java.util.Arrays;

public class DuplicateFromNPlus1 {

    // 🔹 Brute Force: Sort and check adjacent elements
    // Time: O(n log n), Space: O(1)
    public static int findDuplicate1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return arr[i]; // duplicate found
            }
        }
        return 0;
    }

    // 🔹 Better Approach: Using frequency array
    // Time: O(n), Space: O(n)
    public static int findDuplicate2(int[] arr) {
        int[] freq = new int[arr.length];
        for (int num : arr) {
            if (freq[num] == 0) {
                freq[num]++; // mark visited
            } else {
                return num; // already visited → duplicate
            }
        }
        return 0;
    }

    // 🔹 Optimal Approach (Floyd’s Cycle Detection)
    // Treat array as a linked list where value = next index
    // Slow moves 1 step, Fast moves 2 steps
    // When they meet, it means a cycle exists
    // Then reset fast to start and move both 1 step each to find duplicate
    // Time: O(n), Space: O(1)
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Phase 1: Detect cycle (find intersection point)
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance of the cycle = duplicate element
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow; // or fast, both point to duplicate
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2, 5};
        System.out.println(findDuplicate(arr)); // Output: 2
    }
}