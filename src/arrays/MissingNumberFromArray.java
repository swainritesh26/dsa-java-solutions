package arrays;

public class MissingNumberFromArray {

    // Finds the missing number in an array from 0 to n
    public static int missingNumber(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int ans = n * (n + 1) / 2; // sum of first n numbers
        for (int num : arr) {
            sum += num; // sum of array elements
        }
        return ans - sum; // missing number
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr)); // output missing number
    }
}
