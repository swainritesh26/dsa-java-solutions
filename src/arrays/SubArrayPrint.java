package arrays;

public class SubArrayPrint {

    // Function to find the maximum subarray sum (Kadane’s Algorithm)
    // and print the actual subarray that gives this maximum sum.
    public static int maxSubArray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;  // stores the maximum sum found so far
        int sum = 0;                     // current running subarray sum
        int start = -1, end = -1;        // final subarray boundaries
        int first = -1;                  // temporary start index of current subarray

        for (int i = 0; i < arr.length; i++) {

            // when current sum becomes 0, mark new start position
            if (sum == 0) first = i;

            // add current element to running sum
            sum += arr[i];

            // if new sum is greater than maxSum → update maxSum and subarray indices
            if (sum > maxSum) {
                maxSum = sum;
                start = first;
                end = i;
            }

            // if running sum goes negative, reset it to 0 (discard current subarray)
            if (sum < 0) {
                sum = 0;
            }
        }

        // print the subarray that gives the maximum sum
        System.out.print("Max Subarray: ");
        for (int k = start; k <= end; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum = " + maxSubArray(arr));
    }
}