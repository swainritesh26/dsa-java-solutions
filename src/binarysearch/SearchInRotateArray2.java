package binarysearch;

public class SearchInRotateArray2 {

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the target
            if (nums[mid] == target) return true;

            // If we cannot decide (because of duplicates)
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // The Left part is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // search in left part
                } else {
                    low = mid + 1;  // search in the right part
                }
            }
            // The Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // search in the right part
                } else {
                    high = mid - 1; // search in left part
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,5,6,0,0,1,2};
        System.out.println(search(arr1, 0)); // true

        int[] arr2 = {2,5,6,0,0,1,2};
        System.out.println(search(arr2, 3)); // false

        int[] arr3 = {1,1,1,3,1};
        System.out.println(search(arr3, 3)); // true
    }
}
