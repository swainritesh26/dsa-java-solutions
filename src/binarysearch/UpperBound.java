package binarysearch;

public class UpperBound {

    // Returns the index of the first element > x (upper bound)
    public static int upperBound(int[] arr, int x) {
        int n = arr.length;
        int ans = n; // default (if no element >= x, return n)
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                ans = mid;       // possible answer
                right = mid - 1;  // look in left half
            } else {
                left = mid + 1;  // look in right half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int x = 2;
        System.out.println(upperBound(arr, x));
    }
}
