package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatingAndMissing {

    // ✅ Function to find the repeating and missing numbers in an array
    //  contains numbers from 1 to N with one missing and one repeating
    public static int[] findMissingRepeatingNumbers(int[] arr) {
        Set<Integer> st = new HashSet<>();   // To track visited elements
        int repeating = 0;                   // To store the repeating number
        int sum = 0;                         // Sum of all elements in array

        // Expected sum of first N natural numbers
        int n = arr.length * (arr.length + 1) / 2;

        // Step 1: Find the repeating number using HashSet
        for (int num : arr) {
            if (!st.add(num)) {              // If already present → repeating number found
                repeating = num;
            }
        }

        // Step 2: Calculate actual sum of all elements
        for (int num : arr) {
            sum += num;
        }

        // Step 3: Use the formula to find the missing number
        // ExpectedSum = (SumOfArray - Repeating) + Missing
        // => Missing = Repeating - (SumOfArray - ExpectedSum)
        int missing = repeating - (sum - n);

        // Return both numbers as an array [repeating, missing]
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}
