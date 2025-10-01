package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

    // Function to find leaders in the array
    // A leader is an element that is strictly greater than all elements to its right
    public static List<Integer> leaders(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        // The last element is always a leader
        int k = nums[nums.length - 1];
        ls.add(k);

        // Traverse from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > k) {
                k = nums[i];      // update current max from the right
                ls.add(nums[i]);  // add leader
            }
        }

        // Reverse because we collected leaders from right to left
        Collections.reverse(ls);
        return ls;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 1, 2};
        List<Integer> ls = leaders(arr);
        System.out.println(ls);
    }
}
