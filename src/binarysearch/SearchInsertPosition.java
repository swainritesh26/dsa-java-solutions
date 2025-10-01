package binarysearch;

public class SearchInsertPosition {

    public static int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(arr, target));
    }
}
