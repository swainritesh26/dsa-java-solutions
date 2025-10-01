package binarysearch;

public class LowerBound {

    // Returns the index of the first element >= x (lower bound)
    public static int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int ans = n; // default (if no element >= x, return n)
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = mid;       // candidate for lower bound
                right = mid - 1; // look in left half
            } else {
                left = mid + 1;  // look in right half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        System.out.println(lowerBound(arr, x));
    }
}
