package arrays;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(check(arr));
    }
    public static boolean check(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
